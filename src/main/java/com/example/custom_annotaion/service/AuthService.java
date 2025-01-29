package com.example.custom_annotaion.service;

import com.example.custom_annotaion.dto.LoginRequest;
import com.example.custom_annotaion.dto.LoginResponse;
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
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = jwtUtil.generateToken(user.getUsername(), List.of(user.getRoles().split(",")));
        return new LoginResponse(token);
    }
}
