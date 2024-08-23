package com.learn.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// REST API
@RestController
public class HelloWorldController {
	
	// /hello-world
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "hello world!";
	}
	
	// return hello world bean
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello world!");
	}
	
	// path variables
	@GetMapping(path = "/hello-world/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("hello " + name + "!");
	}
}
