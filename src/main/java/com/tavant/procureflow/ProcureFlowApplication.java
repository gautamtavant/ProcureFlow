package com.tavant.procureflow;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProcureFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcureFlowApplication.class, args);
    }

    @Bean
    CommandLineRunner generatePasswordHash(PasswordEncoder passwordEncoder) {
        return args -> {
            System.out.println(
                    "BCrypt hash: " +
                            passwordEncoder.encode("Password@123")
            );
        };
    }
}