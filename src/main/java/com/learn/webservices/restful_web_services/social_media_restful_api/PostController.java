package com.learn.webservices.restful_web_services.social_media_restful_api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	private PostRepository postRepository;
	
	public PostController(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}
	
	// / get all posts
	// GET /posts
	@GetMapping(path = "/posts")
	public ResponseEntity<List<Post>> getAllPosts() {
		List<Post> allPosts = postRepository.findAll();
		return new ResponseEntity<>(allPosts, HttpStatus.OK);
	}
	
	// get all user posts
	@GetMapping(path = "/posts/{user_id}")
	public ResponseEntity<List<Post>> getAllPostsById(@PathVariable Integer user_id) {
		List<Post> postsById = postRepository.findByUserId(user_id);
		return new ResponseEntity<>(postsById, HttpStatus.OK);
	}
	
	// create a posts for a user 
	// POST /usesrs/{id}/posts
	@PostMapping(path = "/users/{user_id}/posts")
	public ResponseEntity<Post> createPostById(@PathVariable Integer user_id,@RequestParam String description) {
		Post newPost = new Post(user_id,description);
		postRepository.save(newPost);
		return new ResponseEntity<>(newPost, HttpStatus.CREATED);
	}
	
	// retrieve details of a post
	// GET /users/{id}/posts/{post_id}
	@GetMapping(path = "/users/{user_id}/posts/{post_id}")
	public ResponseEntity<Post>  getPostsById(@PathVariable Integer user_id, @PathVariable Integer post_id) {
		List<Post> postsByUserId = postRepository.findByUserId(user_id);
		for (Post post: postsByUserId) {
			if (post.getPostId().equals(post_id)) { 
				return new ResponseEntity<>(post, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}

	public PostRepository getPostRepository() {
		return postRepository;
	}

	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
}
