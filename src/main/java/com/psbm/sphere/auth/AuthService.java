package com.psbm.sphere.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.psbm.sphere.user.UserRepository;

@Service
public class AuthService {
    @Autowired
    UserRepository repository;

    @Autowired
    TokenService tokenService;

    @Autowired
    PasswordEncoder encoder;
    
    public Token login(Credentials credentials){
        var user = repository.findByEmail(credentials.email()).orElseThrow( () -> new RuntimeException("User not found."));

        if( ! encoder.matches(credentials.password(), user.getPassword()) ){
            throw new RuntimeException("Acess denied");
        }

        return tokenService.createToken(user.getEmail());
    }
}
