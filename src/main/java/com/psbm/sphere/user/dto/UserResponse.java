package com.psbm.sphere.user.dto;

import java.time.LocalDateTime;

import com.psbm.sphere.user.User;

public record UserResponse(Long id, String nome, String bio, String email, LocalDateTime updatedAt) {

    public static UserResponse from(User saved) {
        return new UserResponse(
                saved.getId(),
                saved.getName(),
                saved.getBio(),
                saved.getEmail(),
                saved.getUpdatedAt());
    }

}
