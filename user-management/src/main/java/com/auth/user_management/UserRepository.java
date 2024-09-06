package com.auth.user_management;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<CustomUser, Integer> {
    Optional<CustomUser> findByEmail(String email);
}
