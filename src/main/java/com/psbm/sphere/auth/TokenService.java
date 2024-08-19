package com.psbm.sphere.auth;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class TokenService {

    public Token createToken(String email){
        var expire = LocalDateTime.now().plus(1, ChronoUnit.HOURS).toInstant(ZoneOffset.UTC);

        Algorithm algorithm = Algorithm.HMAC256("cincooitodoiscincomeiaquatrodoisum");

        String token = JWT.create()
        .withSubject(email)
        .withExpiresAt(expire)
        .sign(algorithm);

        return new Token(token, email);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
