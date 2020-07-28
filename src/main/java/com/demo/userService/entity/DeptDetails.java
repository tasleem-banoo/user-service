package com.demo.userService.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DeptDetails {
	
	@Id
	@ApiModelProperty(notes = "Unique Id of Dept")
	private String id;
	@ApiModelProperty(notes = "Dept Name")
	private String deptName;
	@ApiModelProperty(notes = "Dept Type")
	private String deptType;
	
}
