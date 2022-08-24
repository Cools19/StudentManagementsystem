package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;

@Service
public class StudentSevice implements IStudentService {

	@Autowired
	IStudentRepository studentRepository;

	@Override
	public Integer saveStudent(Student student) {
		Student savedStudent = studentRepository.save(student);
		return savedStudent.getId();
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudent(Integer id) {
		return studentRepository.findById(id);
	}

	@Override
	public String deleteStudent(Integer id) {
		studentRepository.deleteById(id);
		return "deleted";
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		Student existingStudent = studentRepository.findById(id).orElse(student);

		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setStudentClass(student.getStudentClass());
		existingStudent.setSubject(student.getSubject());
		existingStudent.setDob(student.getDob());
		studentRepository.save(student);
		return existingStudent;

	}

	@Override
	public void deleteAll() {
		studentRepository.deleteAll();
	}
}
