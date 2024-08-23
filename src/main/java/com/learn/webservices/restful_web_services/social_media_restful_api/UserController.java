package com.learn.webservices.restful_web_services.social_media_restful_api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	// Retrieve all users
	// GET /users
	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}
	
	// create a user
	// POST /users
	@PostMapping(path = "/users")
	public User createUser(@RequestParam String name,@RequestParam LocalDate birthDate) {
		User newUser = new User(name,birthDate);
		userRepository.save(newUser);
		return newUser;
	}
	
	// retrieve a user
	// GET /users/{id}
	@GetMapping(path = "/users/{id}")
	public User getUserById(@PathVariable Integer id) {
		User userById = userRepository.findById(id).get();
		return userById;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
