package com.learn.webservices.restful_web_services.social_media_restful_api;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private Logger logger = LoggerFactory.getLogger(getClass());

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
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		logger.debug(user.toString());
		// save new user
		userRepository.save(user);

		// location of created resource
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).body(user);
	}

	// retrieve a user
	// GET /users/{id}
	@GetMapping(path = "/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		User userById = userRepository.findById(id).get();
		return new ResponseEntity<>(userById, HttpStatus.OK);
	}

	// delete a user
	// GET /users/delete/{id}
	@GetMapping(path = "/users/delete/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Integer id) {
		User userById = userRepository.findById(id).get();
		userRepository.delete(userById);
		return new ResponseEntity<>("User deleted.", HttpStatus.OK);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
