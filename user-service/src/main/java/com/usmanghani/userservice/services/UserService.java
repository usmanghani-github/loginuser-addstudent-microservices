package com.usmanghani.userservice.services;

import com.usmanghani.userservice.entities.User;
import com.usmanghani.userservice.vo.ResponseTemplateVO;

public interface UserService {

	User addUser(User user);

	User getUserById(Integer userId);

	ResponseTemplateVO getUserWithStudentRecord(Integer userId);

	User checkUser(String email);

}
