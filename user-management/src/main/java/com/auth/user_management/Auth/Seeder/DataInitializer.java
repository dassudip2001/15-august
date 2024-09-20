package com.auth.user_management.Auth.Seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.auth.user_management.Auth.Entity.CustomUser;
import com.auth.user_management.Auth.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        

        // Check if user with the email 'admin@admin.com' already exists
        if (userRepository.findByEmail("admin@admin.com").isEmpty()) {
            // Create a new user only if it doesn't exist
            CustomUser user = new CustomUser();
            user.setFullName("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("password"));
            user.setEmail("admin@admin.com");
            user.setRole("ROLE_ADMIN");

            userRepository.save(user);

            System.out.println("Admin user created.");
        } else {
            System.out.println("Admin user already exists.");
        }
    }

}
