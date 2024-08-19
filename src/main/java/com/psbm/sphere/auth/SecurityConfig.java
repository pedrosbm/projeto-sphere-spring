package com.psbm.sphere.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(auth -> 
            auth.requestMatchers(HttpMethod.POST, "/login").permitAll()
        );

    return http.build();
    }
}
