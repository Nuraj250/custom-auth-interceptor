package com.example.custom_annotaion.exception;

public class JwtTokenException extends RuntimeException {
    public JwtTokenException(String message) {
        super(message);
    }
}
