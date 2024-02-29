package com.socialmedia.service;

import com.socialmedia.entities.User;

import java.util.List;

public interface UserService {


    String createUser(User user);

    String updateUser(User user);

    void deleteUser(Integer userId);

    User getUser(Integer userId);

    List<User> getAllUsers();


}
