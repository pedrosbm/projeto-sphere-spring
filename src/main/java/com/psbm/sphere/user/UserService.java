package com.psbm.sphere.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repo;
    
    public List<User> findAll(Pageable pageable){
        return repo.findAll();
    }

    public User create(User user){
        return repo.save(user);
    }
}
