package com.demo.userService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.userService.entity.User;

@RestController
public class UserController {
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable("userId") int userId) {
		User user = new User();
		user.setFirstName("Tasleem");
		user.setLastName("Banoo");
		user.setUserId(1);
		return user;
	}

}
