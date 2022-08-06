package com.usmanghani.userservice.serviceimplimentation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usmanghani.userservice.entities.User;
import com.usmanghani.userservice.exception.ResourceNotFoundException;
import com.usmanghani.userservice.repository.UserRepository;
import com.usmanghani.userservice.services.UserService;
import com.usmanghani.userservice.vo.ResponseTemplateVO;
import com.usmanghani.userservice.vo.Student;

@Service
public class UserServiceImplimentation implements UserService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		user.setActive(true);
		user.setInsertDate(new Date());
		user.setExpiryDate(null);
		return this.userRepository.save(user);
	}

	@Override
	public User getUserById(Integer userId) throws ResourceNotFoundException {
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
	}

	@Override
	public ResponseTemplateVO getUserWithStudentRecord(Integer userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		Student student = restTemplate.getForObject("http://STUDENT-SERVICE/students/" + user.getStudentId(),
				Student.class);
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		responseTemplateVO.setUser(user);
		responseTemplateVO.setStudent(student);
		return responseTemplateVO;
	}

	

	@Override
	public User checkUser(String email) {
		User user = this.userRepository.findByEmail(email);
		System.out.println(user);
		return user;
	}
}
