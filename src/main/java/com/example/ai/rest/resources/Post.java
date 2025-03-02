package com.example.ai.rest.resources;

import lombok.Data;

@Data
public class Post {
    private Long id;
    private Long userId;
    private String title;
    private String body;
}