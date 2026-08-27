package com.tavant.procureflow.auth.service;

import com.tavant.procureflow.auth.dto.LoginRequest;
import com.tavant.procureflow.auth.dto.LoginResponse;
import com.tavant.procureflow.auth.security.JwtService;
import com.tavant.procureflow.user.entity.AppUser;
import com.tavant.procureflow.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {

        AppUser user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!user.isActive()) {
            throw new RuntimeException("User is inactive");
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPasswordHash()
        )) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token);
    }
}