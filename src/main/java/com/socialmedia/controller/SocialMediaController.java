package com.socialmedia.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.socialmedia.entities.Post;
import com.socialmedia.entities.User;
import com.socialmedia.service.PostService;
import com.socialmedia.service.UserService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialMediaController {

    private final UserService userService;
    private final PostService postService;

    public SocialMediaController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    //Entity Model
    //WebMvcLinkBuilder
    //Get User By Id
    @GetMapping("/user/{userId}")
    public EntityModel<User> getUserById(@PathVariable("userId") Integer userId) {
        User user = userService.getUser(userId);
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    //Get All Users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //Create User
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    //Update User
    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }

    //Delete User
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    // Get Posts by User ID
    @GetMapping("/users/{userId}/posts")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable("userId") Integer userId) {
        List<Post> posts = postService.getPosts(userId);
        return ResponseEntity.ok(posts);
    }

    // Get All Posts
    @GetMapping("/users/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    // Create a Post
    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<String> createPost(@PathVariable("userId") Integer userId, @Valid @RequestBody Post post) {
        try {
            String result = postService.createPost(userId, post);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create post: " + e.getMessage());
        }
    }
}