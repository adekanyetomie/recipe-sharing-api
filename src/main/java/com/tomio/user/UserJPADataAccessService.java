package com.tomio.user;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserJPADataAccessService implements UserDAO {

    private final UserRepository userRepository;

    public UserJPADataAccessService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserProfile> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserProfile> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<UserProfile> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void addUser(UserProfile userProfile) {
        userRepository.save(userProfile);
    }

    @Override
    public void updateUser(UserProfile userProfile) {
        userRepository.save(userProfile);

    }

    @Override
    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean isUserExists(String username) {
        return userRepository.existsByUsername(username);
    }

}
