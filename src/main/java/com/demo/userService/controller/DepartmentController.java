package com.demo.userService.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.userService.entity.DeptDetails;
import com.demo.userService.service.DeptService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class DepartmentController {
	
	/* spring-boot-starter-web has spring-boot-starter-logging and this logging has spring-jcl dependencies. This stands for spring commons logging bridge which makes logging available 
	 * What is actually logging? sl4j is just a interface what is the actual implementation? 
	 * Default implementation in spring boot when we use starter dependency is LogBack. LogBack is a framework which is kind of succesor to log4j framework which is very popular. 
	 *  */
	Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DeptService deptService;
	
	@GetMapping("/depts")
	@ApiOperation(value="Get All Departments", notes="Call this to get all departments in system"
	,response = DeptDetails.class)
	public List<DeptDetails> getAllDepts() {
		logger.info("Getting all departments");
		return deptService.getAllDepts();
	}
	
	@GetMapping("/depts/{id}")
	@ApiOperation(value="Get Department By ID", notes="Call this to get departments by Id"
	,response = DeptDetails.class)
	public Optional<DeptDetails> getDept(@ApiParam(value="Id of the dept that you need to retrieve",required = true)
			@PathVariable String id) {
		logger.trace("Get Department By Id method accessed"); //by default this will be not shown in console. Default log level is info or above. we need to define property to show trace.
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
