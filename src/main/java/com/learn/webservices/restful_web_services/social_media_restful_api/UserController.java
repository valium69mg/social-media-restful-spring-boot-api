package com.learn.webservices.restful_web_services.social_media_restful_api;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	// Retrieve all users
	// GET /users
	@GetMapping(path = "/users")
	public String getAllUsers() {
		return "all users";
	}
	
	// create a user
	// POST /users
	@PostMapping(path = "/users")
	public User createUser(@RequestParam String name,@RequestParam LocalDate birthDate) {
		return new User(name,birthDate);
	}
	
	// retrieve a user
	// GET /users/{id}
	@GetMapping(path = "/users/{id}")
	public User getUserById(@PathVariable Integer id) {
		return new User();
	}
}
