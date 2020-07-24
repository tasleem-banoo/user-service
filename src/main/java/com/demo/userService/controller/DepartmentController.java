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
import com.demo.userService.service.DeptService;

@RestController
public class DepartmentController {

	@Autowired
	private DeptService deptService;
	
	@GetMapping("/depts")
	public List<DeptDetails> getAllDepts() {
		return deptService.getAllDepts();
	}
	
	@GetMapping("/depts/{id}")
	public Optional<DeptDetails> getDept(@PathVariable String id) {
		return deptService.getDept(id);
	}
	
	@RequestMapping(value="/depts",method=RequestMethod.POST)
	public String addDept(@RequestBody DeptDetails dept) {
		return deptService.addDept(dept);
	}
	
	@RequestMapping(value="/depts/{id}",method=RequestMethod.PUT)
	public String updateDept(@RequestBody DeptDetails dept, @PathVariable String id) {
		return deptService.updateDept(dept);
	}
	
	@RequestMapping(value="/depts/{id}",method=RequestMethod.DELETE)
	public String deleteDept(@PathVariable String id) {
		return deptService.deleteDept(id);
	}
}
