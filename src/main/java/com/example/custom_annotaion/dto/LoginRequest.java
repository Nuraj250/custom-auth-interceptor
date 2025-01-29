package com.example.custom_annotaion.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
