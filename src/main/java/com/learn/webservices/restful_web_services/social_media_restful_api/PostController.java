package com.learn.webservices.restful_web_services.social_media_restful_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	// / get all posts
	// GET /posts
	@GetMapping(path = "/posts")
	public String getAllPosts() {
		return "all posts";
	}
	
	// get all user posts
	@GetMapping(path = "/posts/{id}")
	public String getAllPostsById(@PathVariable Integer id) {
		return "all posts by id";
	}
	
	// create a posts for a user 
	// POST /usesrs/{id}/posts
	@PostMapping(path = "/users/{id}/posts")
	public String createPostById(@PathVariable Integer id,@RequestParam String description) {
		return "created a post";
	}
	
	// retrieve details of a post
	// GET /users/{id}/posts/{post_id}
	@GetMapping(path = "/users/{id}/posts/{post_id}")
	public String getPostsById(@PathVariable Integer id, @PathVariable Integer post_id) {
		return "all users posts";
	}
	
}
