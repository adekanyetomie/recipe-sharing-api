package com.tomio.user;

import com.tomio.exceptions.DuplicateResourceException;
import com.tomio.exceptions.ResourceNotFoundException;
import com.tomio.recipe.Recipe;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDAO userDAO;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<UserProfile> getAllUsers() {
        return userDAO.getAllUsers();
    }
    //deal with this exception
    public UserProfile getUserById(Integer id) {
        return userDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer with id " + id + " not found"));
    }

    public UserProfile getUserByUsername(String username) {
        return userDAO.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("customer with name " + username + " not found"));
    }

    public UserProfile getUserByEmail(String email) {
        return userDAO.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("customer with email " + email + " not found"));
    }

    public void addUser(UserProfile userRequest) {
        String email = userRequest.getEmail();
        String password = userRequest.getPassword();
        String username = userRequest.getUsername();

        if (userDAO.isUserExists(username)) {
            throw new DuplicateResourceException("customer with name " + username + " already exists");
        }

        if (userDAO.isUserExists(email)) {
            throw new DuplicateResourceException("customer with email " + email + " already exists");
        }

        UserProfile user = new UserProfile(username, email, password);
        user.setPassword(encoder.encode(password));
        userDAO.addUser(user);

    }

    public void deleteUserByUsername(String username) {
        if (!userDAO.isUserExists(username)) {
            throw new ResourceNotFoundException("customer with name " + username + " not found");
        }
        userDAO.deleteUserByUsername(username);
    }

    public void deleteUserByEmail(String email) {
        if (!userDAO.isUserExists(email)) {
            throw new ResourceNotFoundException("customer with email " + email + " not found");
        }
        userDAO.deleteUserByEmail(email);
    }


}
