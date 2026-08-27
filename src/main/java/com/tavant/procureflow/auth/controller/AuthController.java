package com.tavant.procureflow.auth.controller;

import com.tavant.procureflow.auth.dto.LoginRequest;
import com.tavant.procureflow.auth.dto.LoginResponse;
import com.tavant.procureflow.auth.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}