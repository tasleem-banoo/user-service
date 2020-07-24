package com.demo.userService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.userService.entity.DeptDetails;
import com.demo.userService.entity.UserDetails;
import com.demo.userService.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/depts/{deptId}/users")
	public List<UserDetails> getAllUsers(@PathVariable String deptId) {
		return userService.getAllUsers(deptId);
	}
	
	@GetMapping("/depts/{deptId}/users/{id}")
	public Optional<UserDetails> getUserInDept(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(value="/depts/{deptId}/users",method=RequestMethod.POST)
	public String addUser(@RequestBody UserDetails user, @PathVariable String deptId) {
		user.setDept(new DeptDetails(deptId,"",""));
		return userService.addUser(user);
	}
	
	@RequestMapping(value="/depts/{deptId}/users/{id}",method=RequestMethod.PUT)
	public String updateUser(@RequestBody UserDetails user, @PathVariable int id, @PathVariable String deptId) {
		user.setDept(new DeptDetails(deptId,"", ""));
		return userService.updateUser(id,user);
	}
	
	@RequestMapping(value="/depts/{deptId}/users/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}
	
	@GetMapping("/user/{userId}")
	public Optional<UserDetails> getUser(@PathVariable int userId) {
		return userService.getUser(userId);
	}
	

}
