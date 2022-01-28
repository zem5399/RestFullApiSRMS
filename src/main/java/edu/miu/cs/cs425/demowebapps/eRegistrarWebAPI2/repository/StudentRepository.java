package edu.miu.cs.cs425.demowebapps.eRegistrarWebAPI2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs.cs425.demowebapps.eRegistrarWebAPI2.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{

	   
}
