package edu.miu.cs.cs425.demowebapps.eRegistrarWebAPI2.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs425.demowebapps.eRegistrarWebAPI2.model.Student;
import edu.miu.cs.cs425.demowebapps.eRegistrarWebAPI2.repository.StudentRepository;
import edu.miu.cs.cs425.demowebapps.eRegistrarWebAPI2.service.StudentService;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student s) {
		// TODO Auto-generated method stub
		return studentRepository.save(s);
	}

	@Override
	public Student getStudentById(Integer studentId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(studentId).orElse(null);
	}

	@Override
	public Student updateStudent(Student s, Integer studentId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(studentId)
				.map(studentInfoUpdate -> {
					studentInfoUpdate.setAdmissionDate(s.getAdmissionDate());
					studentInfoUpdate.setCgpa(s.getCgpa());
					studentInfoUpdate.setFirstName(s.getFirstName());
					studentInfoUpdate.setLastName(s.getLastName());
					studentInfoUpdate.setStudentNumber(s.getStudentNumber());
				return studentRepository.save(studentInfoUpdate);
				}).orElseGet(()-> {
					return studentRepository.save(s);
				});
	}
	

	@Override
	public void deleteStudentById(Integer studentId) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(studentId);
	}

}
