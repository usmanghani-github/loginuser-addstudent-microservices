package com.usmanghani.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	private Integer studentId;
	private String name;
	private String email;
	private String password;
	private int mobileNo;
	private String dob;

}
