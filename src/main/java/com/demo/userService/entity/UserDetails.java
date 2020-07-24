package com.demo.userService.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Data is equivalent to @Getter + @Setter + @RequiredArgsConstructor + @ToString + @EqualsAndHashCode
@Data
@Entity
@NoArgsConstructor
public class UserDetails {
	
	@Id
	private int id;
	private String firstName;
	private String lastName;
	
	@ManyToOne
	private DeptDetails dept;

	public UserDetails(int id, String firstName, String lastName, String deptId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = new DeptDetails(deptId,"","");
	}
	
	

}
