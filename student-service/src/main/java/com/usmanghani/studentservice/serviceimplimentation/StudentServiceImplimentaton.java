package com.usmanghani.studentservice.serviceimplimentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usmanghani.studentservice.entities.Student;
import com.usmanghani.studentservice.repository.StudentRepository;
import com.usmanghani.studentservice.service.StudentService;

@Service
public class StudentServiceImplimentaton implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return this.studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Integer studentId) throws Exception {
		Student student = this.studentRepository.findById(studentId)
				.orElseThrow(() -> new Exception("Student Not Found"));
		return student;
	}

}
