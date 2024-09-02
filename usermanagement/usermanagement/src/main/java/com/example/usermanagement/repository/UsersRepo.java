package com.example.usermanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.usermanagement.entity.OurUsers;

@Repository
public interface UsersRepo  extends JpaRepository<OurUsers, Integer> {
    Optional<OurUsers> findByEmail(String email);
    OurUsers findByEmailAndPassword(String email, String password);

}
