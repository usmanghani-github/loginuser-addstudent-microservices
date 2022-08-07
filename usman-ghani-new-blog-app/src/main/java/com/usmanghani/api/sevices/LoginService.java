package com.usmanghani.api.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usmanghani.api.entities.User;

@Service
public class LoginService {

	@Autowired
	private RestTemplate restTemplate;

	public String checkUserLogin(String email, String password) {
		System.out.println(email + password);
		User user = restTemplate.getForObject("http://USER-SERVICE/users/email/" + email, User.class);
		if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
			System.out.println(user);
			return "User Login Sucessfully";
		}
		return "invalid credentials";
	}

}
