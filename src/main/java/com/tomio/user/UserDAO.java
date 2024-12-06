package com.tomio.user;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<UserProfile> getAllUsers();
    Optional<UserProfile> findById(Integer id);
    Optional<UserProfile> findByUsername(String username);
    Optional<UserProfile> findByEmail(String email);
    void addUser(UserProfile userProfile);
    void updateUser(UserProfile userProfile);
    void deleteUserByUsername(String username);
    void deleteUserByEmail(String email);
    boolean isUserExists(String username);
    void deleteUserById(Integer id);
}
