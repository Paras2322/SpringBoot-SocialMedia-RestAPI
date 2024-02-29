package com.socialmedia.service.implementation;

import com.socialmedia.entities.User;
import com.socialmedia.exception.NoUsersFoundException;
import com.socialmedia.exception.UserNotFoundException;
import com.socialmedia.repository.UserRepository;
import com.socialmedia.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public String createUser(User user) {
        try {
            userRepository.save(user);
            return "User Added Successfully !!";
        } catch (Exception e) {
            throw new RuntimeException("Failed to add User: " + e.getMessage());
        }
    }

    @Override
    public String updateUser(User user) {
        Integer userId = user.getId();
        try {
            if (!userRepository.existsById(userId)) {
                throw new UserNotFoundException("User not found with ID: " + userId);
            }
            userRepository.save(user);
            return "User Updated Successfully";
        } catch (Exception e) {
            throw new RuntimeException("Failed to update user: " + e.getMessage());
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        try {
            if (!userRepository.existsById(userId)) {
                throw new UserNotFoundException("User not found with ID: " + userId);
            }
            userRepository.deleteById(userId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete user: " + e.getMessage());
        }
    }

    @Override
    public User getUser(Integer userId) {
        try {
            return userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve User: " + e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            List<User> users = userRepository.findAll();
            if (users.isEmpty()) {
                throw new NoUsersFoundException("No Users found");
            }
            return users;
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve users: " + e.getMessage());
        }
    }
}


