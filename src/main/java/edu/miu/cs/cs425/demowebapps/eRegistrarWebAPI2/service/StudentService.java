package edu.miu.cs.cs425.demowebapps.eRegistrarWebAPI2.service;

import java.util.List;

import edu.miu.cs.cs425.demowebapps.eRegistrarWebAPI2.model.Student;

public interface StudentService {
	public abstract List<Student> getAllStudents();
	public abstract Student saveStudent(Student s);
	public abstract Student getStudentById(Integer studentId);
	public abstract Student updateStudent(Student s, Integer studentId);
	public abstract void deleteStudentById(Integer studentId);
	
}
