package com.revature.services;

import com.revature.models.Role;
import com.revature.web.dtos.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo=repo;
    }

    @Transactional
    public User register(User user) {
        Role role = new Role(2, "MEMBER");
        user.setRole(role);
        repo.save(user);
        return user;
    }

    @Transactional
    public User authenticate(Credentials creds) {
        return repo.findByCredentials(creds);
    }
}