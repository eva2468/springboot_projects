package com.example.sample.service;

import java.util.List;

import com.example.sample.model.Student;


public interface StudentService {

	Student saveStudent(Student student);
	List <Student> getAllstudents();
	Student getStudentById(Long id);
	Student updateStudent(Student student,Long id);
	void deleteStudent(Long id);
	
}
