package com.demo.userService.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

//@Data is equivalent to @Getter + @Setter + @RequiredArgsConstructor + @ToString + @EqualsAndHashCode
@Data
//@Entity
public class User {
	
	//@Id
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int userId;
	private String firstName;
	private String lastName;

}
