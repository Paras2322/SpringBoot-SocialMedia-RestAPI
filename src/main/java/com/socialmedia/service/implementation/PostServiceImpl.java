package com.socialmedia.service.implementation;

import com.socialmedia.entities.Post;
import com.socialmedia.entities.User;
import com.socialmedia.exception.UserNotFoundException;
import com.socialmedia.repository.PostRepository;
import com.socialmedia.repository.UserRepository;
import com.socialmedia.service.PostService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public PostServiceImpl(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getPosts(Integer userId) {
        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));

            List<Post> posts = user.getPosts();
            // Set the user for each post
            for (Post post : posts) {
                post.setUser(user);
            }
            return posts;
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve Posts for user ID " + userId + ": " + e.getMessage());
        }
    }

    @Override
    public List<Post> getAllPosts() {
        try {
            return postRepository.findAll();
        } catch (Exception e) {
            // Handle exceptions
            throw new RuntimeException("Failed to retrieve Posts: " + e.getMessage());
        }
    }

    @Override
    public String createPost(Integer userId, Post post) {
        try {
            // Find the user by userId
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
            post.setUser(user);
            // Save the post
            postRepository.save(post);

            return "Post Created Successfully";
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Post: " + e.getMessage());
        }
    }

}
