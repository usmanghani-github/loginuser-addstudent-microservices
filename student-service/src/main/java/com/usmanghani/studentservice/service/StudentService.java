package com.usmanghani.studentservice.service;

import com.usmanghani.studentservice.entities.Student;

public interface StudentService {

	Student addStudent(Student student);

	Student getStudentById(Integer studentId) throws Exception;

}
