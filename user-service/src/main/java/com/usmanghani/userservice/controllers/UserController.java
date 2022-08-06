package com.usmanghani.userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usmanghani.userservice.entities.User;
import com.usmanghani.userservice.services.UserService;
import com.usmanghani.userservice.vo.ResponseTemplateVO;

@RestController
@RequestMapping("/users/")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/go")
	public String men() {
		return "usman";
	}

	@PostMapping("/")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return ResponseEntity.ok(this.userService.addUser(user));

	}

//	@GetMapping("{userId}")
//	public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
//
//		return ResponseEntity.ok(this.userService.getUserById(userId));
//	}
	@GetMapping("{userId}")
	public ResponseTemplateVO getUserWithStudentRecord(@PathVariable Integer userId) {
		ResponseTemplateVO userWithStudentRecord = this.userService.getUserWithStudentRecord(userId);

		return userWithStudentRecord;
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<User> checkUser(@PathVariable String email) {
		System.out.println(email);
		User user = this.userService.checkUser(email);
		return ResponseEntity.ok(user);
	}

}
