package com.psbm.sphere.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.psbm.sphere.user.dto.UserRequest;
import com.psbm.sphere.user.dto.UserResponse;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping
    public List<User> findAll(@PageableDefault Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest, UriComponentsBuilder uriBuilder) {
        var saved = service.create(userRequest.toModel());
        var uri = uriBuilder
                .path("/user/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(UserResponse.from(saved));
    }
}
