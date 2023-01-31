package com.example.sample.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.sample.exception.ResourceNotFoundException;
import com.example.sample.model.Student;
import com.example.sample.repository.StudentRepository;
import com.example.sample.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentrepository;
	
	public StudentServiceImpl(StudentRepository studentrepository) {
		super();
		this.studentrepository = studentrepository;
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		
		return studentrepository.save(student);
	}

	@Override
	public List<Student> getAllstudents() {
		// TODO Auto-generated method stub
		return studentrepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		Optional <Student> student=studentrepository.findById(id);
		if(student.isPresent())
		{
			return student.get();
		}
		else
		{
			throw new ResourceNotFoundException("Student","Id",id);
			
		}
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		
		Student existingStudent= studentrepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Student","Id",id));
			existingStudent.setFirstname(student.getFirstname());
			existingStudent.setLastname(student.getLastname());
			studentrepository.save(existingStudent);
			return existingStudent;
	}

	@Override
	public void deleteStudent(Long id) {
		
		studentrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student","Id",id));
		studentrepository.deleteById(id);
		
	}

}
