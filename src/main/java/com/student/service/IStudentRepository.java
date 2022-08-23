package com.student.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer>  {

	

}
