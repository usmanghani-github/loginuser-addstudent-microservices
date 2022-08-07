package com.usmanghani.api.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String mobileNo;
	private Date insertDate;
	private Date expiryDate;
	private boolean isActive;
	private Integer studentId;

}
