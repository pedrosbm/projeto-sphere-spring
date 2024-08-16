package com.psbm.sphere.user.dto;

import java.time.LocalDateTime;

import com.psbm.sphere.user.User;

public record UserRequest(String nome, String bio, String email, String password) {

    public User toModel() {
        return User.builder()
        .name(nome)
        .bio(bio)
        .email(email)
        .password(password)
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build();
    }
    
}
