package com.learn.webservices.restful_web_services.social_media_restful_api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}
	
	// create a user
	// POST /users
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@RequestParam String name,@RequestParam LocalDate birthDate) {
		User newUser = new User(name,birthDate);
		userRepository.save(newUser);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	// retrieve a user
	// GET /users/{id}
	@GetMapping(path = "/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		User userById = userRepository.findById(id).get();
		return new ResponseEntity<>(userById, HttpStatus.OK);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
