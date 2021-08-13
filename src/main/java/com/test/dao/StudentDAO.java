package com.test.dao;

import java.util.List;

import com.test.models.Student;

public interface StudentDAO {
	
	List<Student> getAllStudents();
	Student getStudentById(Integer studentId);
	Integer addStudent(Student student);
	
}
