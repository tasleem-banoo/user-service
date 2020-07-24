package com.demo.userService.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DeptDetails {
	
	@Id
	private String id;
	private String deptName;
	private String deptType;
	
}
