package com.example.custom_annotaion.service;

import com.example.custom_annotaion.dto.LoginRequest;
import com.example.custom_annotaion.dto.LoginResponse;
import com.example.custom_annotaion.exception.*;
import com.example.custom_annotaion.model.User;
import com.example.custom_annotaion.repository.UserRepository;
import com.example.custom_annotaion.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User not found: " + loginRequest.getUsername()));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new UserNotFoundException("Invalid credentials for user: " + loginRequest.getUsername());
        }

        String token = jwtUtil.generateToken(user.getUsername(), List.of(user.getRoles().split(",")));
        return new LoginResponse(token);
    }
}
