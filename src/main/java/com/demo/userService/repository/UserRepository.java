package com.demo.userService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.userService.entity.UserDetails;

public interface UserRepository extends CrudRepository<UserDetails,Integer> {

	//if find by property is string we can directly call findByDept() but Dept is object so we need to pass the field name also
	public List<UserDetails> findByDeptId(String deptId);
	
	//If we need to find by name then we need to follow below method structure like other jpa methods to get data.
	public List<UserDetails> findByFirstName(String name);
}
