package edu.miu.cs.cs425.demowebapps.eRegistrarWebAPI2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs425.demowebapps.eRegistrarWebAPI2.model.Student;
import edu.miu.cs.cs425.demowebapps.eRegistrarWebAPI2.service.StudentService;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:80" },allowedHeaders = "*")
@RequestMapping(value = "/eRegistrarWebAPI/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
	
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping(value = "/students")
	public List<Student> students(){
		return studentService.getAllStudents();
	}
	
	@PostMapping(value = "/newStudent")
	public Student addStudent(@Valid @RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@PutMapping(value = "/updateStudent/{studentId}")
	public Student updateStudent(@Valid @RequestBody Student student, @PathVariable Integer studentId) {
		return studentService.updateStudent(student, studentId);
	}
	
	@DeleteMapping(value = "/deleteStudent/{studentId}")
	public void deleteStudent(@PathVariable Integer studentId) {
		studentService.deleteStudentById(studentId);
	}
}
