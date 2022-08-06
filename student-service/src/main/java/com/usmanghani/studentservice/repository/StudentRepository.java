package com.usmanghani.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usmanghani.studentservice.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
