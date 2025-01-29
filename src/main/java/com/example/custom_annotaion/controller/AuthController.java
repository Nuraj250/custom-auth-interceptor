package com.example.custom_annotaion.controller;

import com.example.custom_annotaion.annotation.InjectUserContext;
import com.example.custom_annotaion.dto.LoginRequest;
import com.example.custom_annotaion.dto.LoginResponse;
import com.example.custom_annotaion.dto.UserContext;
import com.example.custom_annotaion.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @GetMapping("/me")
    public UserContext getUserContext(@InjectUserContext UserContext userContext) {
        return userContext;
    }
}
