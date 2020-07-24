package com.demo.userService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.userService.entity.DeptDetails;
import com.demo.userService.repository.DeptRepository;

@Service
public class DeptService {
	
	@Autowired
	private DeptRepository deptRepository;
	
	public List<DeptDetails> getAllDepts(){
		List<DeptDetails> deptList = new ArrayList<DeptDetails>();
		deptRepository.findAll().forEach(deptList::add);
		return deptList;
	}
	
	public Optional<DeptDetails> getDept(String id) {
		return deptRepository.findById(id);
	}

	public String addDept(DeptDetails dept) {
		deptRepository.save(dept);
		return dept.getId() +" added successfully";
	}

	public String updateDept(DeptDetails dept) {
		deptRepository.save(dept);
		return dept.getId()+" updated successfully";
	}

	public String deleteDept(String id) {
		deptRepository.deleteById(id);
		return id+" deleted successfully";
	}

}
