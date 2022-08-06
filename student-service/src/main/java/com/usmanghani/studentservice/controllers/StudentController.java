package com.usmanghani.studentservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usmanghani.studentservice.entities.Student;
import com.usmanghani.studentservice.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {

		return ResponseEntity.ok(this.studentService.addStudent(student));
	}

	@GetMapping("{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) throws Exception {

		return ResponseEntity.ok(this.studentService.getStudentById(studentId));
	}
}
