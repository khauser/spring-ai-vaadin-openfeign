package com.example.ai.service;

import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import com.example.ai.rest.JsonPlaceholderClient;
import com.example.ai.rest.resources.Post;

@Service
public class PostService {

    private final JsonPlaceholderClient jsonPlaceholderClient;

    public PostService(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }

    @Tool(name = "fetchPosts", description = "List posts")
    public List<Post> fetchPosts() {
        return jsonPlaceholderClient.getPosts();
    }

}