package com.socialmedia.service;

import com.socialmedia.entities.Post;
import com.socialmedia.entities.User;

import java.util.List;

public interface PostService {

    List getPosts(Integer userId);

    List<Post> getAllPosts();

    String createPost(Integer userId, Post post);

}
