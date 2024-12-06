package com.tomio.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserProfile, Integer> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<UserProfile> findByUsername(String username);
    Optional<UserProfile> findByEmail(String email);
//    Optional<UserProfile> findByUsernameAndPassword(String username, String password);
//    Optional<UserProfile> findByEmailAndPassword(String email, String password);
    void deleteByUsername(String username);
    void deleteByEmail(String email);

}
