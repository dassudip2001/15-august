package com.auth.user_management.Auth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.user_management.Auth.Entity.CustomUser;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<CustomUser, Integer> {
    Optional<CustomUser> findByEmail(String email);
}
