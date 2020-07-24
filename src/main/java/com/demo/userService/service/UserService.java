package com.demo.userService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.userService.entity.UserDetails;
import com.demo.userService.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/*
	 * private List<UserDetails> users = new ArrayList<UserDetails>( Arrays.asList(
	 * new UserDetails(1,"Tasleem","Banoo"), new UserDetails(2,"Palak","Sharma"),
	 * new UserDetails(3,"Amit","Sharma")));
	 */
	
	public List<UserDetails> getAllUsers(String deptId){
		//return users;
		List<UserDetails> userList = new ArrayList<UserDetails>();
		userList = userRepository.findByDeptId(deptId);
		return userList;
	}
	
	public Optional<UserDetails> getUser(int userId) {
		//return users.stream().filter(u -> u.getId()==userId).findFirst().get();
		return userRepository.findById(userId);
	}

	public String addUser(UserDetails user) {
		//users.add(user);
		System.out.println(userRepository.findByFirstName(user.getFirstName()));
		userRepository.save(user);
		return user.getId() +" added successfully";
	}

	public String updateUser(int userId, UserDetails user) {
		/*
		 * for(int i=0;i<users.size();i++) { 
		 * if(users.get(i).getId()==userId)
		 * users.set(i, user); 
		 * }
		 */
		userRepository.save(user);
		return userId+" updated successfully";
	}

	public String deleteUser(int userId) {
		//users.removeIf(user->user.getId()==userId);
		userRepository.deleteById(userId);
		return userId+" deleted successfully";
	}

}
