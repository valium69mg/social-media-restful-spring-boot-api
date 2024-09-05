package com.learn.webservices.restful_web_services.social_media_restful_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
	public Person getFirstVersionOfPerson() {
		return new Person("Carlos","Roman");
	}
	
	@GetMapping("/v2/person")
	public Personv2 getSecondVersionOfPerson() {
		return new Personv2("Carlos Roman");
	}
} 
