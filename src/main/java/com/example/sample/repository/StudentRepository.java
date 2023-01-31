package com.example.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

	
}
