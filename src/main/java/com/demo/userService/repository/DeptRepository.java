package com.demo.userService.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.userService.entity.DeptDetails;

public interface DeptRepository extends CrudRepository<DeptDetails,String> {

	
}
