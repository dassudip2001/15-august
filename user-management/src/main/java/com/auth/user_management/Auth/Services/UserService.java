package com.auth.user_management.Auth.Services;

import org.springframework.stereotype.Service;

import com.auth.user_management.Auth.Entity.CustomUser;
import com.auth.user_management.Auth.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<CustomUser> allUsers() {
        List<CustomUser> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}
