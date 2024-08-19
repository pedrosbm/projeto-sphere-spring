package com.psbm.sphere.auth;

import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthController {
    @Autowired
    TokenService service;

    @PostMapping("/login")
    public Token login(@RequestBody Credentials credentials) {
        return service.createToken(credentials.email());
    }
    
}
