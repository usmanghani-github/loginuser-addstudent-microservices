package com.usmanghani.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usmanghani.api.entities.UserRequestModel;
import com.usmanghani.api.sevices.LoginService;

@RestController
@RequestMapping("/loginservice/")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping("/login/{email}")
	public ResponseEntity<String> checkUserLogin(@RequestBody UserRequestModel requestModel,
			@PathVariable String email) {
		System.out.println(requestModel);
		String userLogin = this.loginService.checkUserLogin(email, requestModel.getPassword());
		return ResponseEntity.ok(userLogin);
	}

	@GetMapping("/go")
	public String men() {
		return "usman";
	}
}
