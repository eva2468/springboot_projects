package com.example.sample.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.model.Student;
import com.example.sample.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {
	
	private StudentService studentservice;

	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}
	
	@PostMapping()
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)
	{
		
		return new ResponseEntity<Student>(studentservice.saveStudent(student),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List <Student> getAllstudents()
	{
	  return studentservice.getAllstudents();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") Long id)
	{
		return new ResponseEntity <Student> (studentservice.getStudentById(id),HttpStatus.OK);
	}
	
	@PostMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student std)
	{
		return new ResponseEntity <Student> (studentservice.updateStudent(std,id),HttpStatus.OK);
	} 
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id")Long id)
	{
		studentservice.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted",HttpStatus.OK);
	}
}
