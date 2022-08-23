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
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		Student existingStudent = studentRepository.findById(id).orElse(student);

		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getFirstName());
		existingStudent.setStudentclass(student.getFirstName());
		existingStudent.setSubject(student.getFirstName());
		existingStudent.setFirstName(student.getFirstName());
		studentRepository.save(existingStudent);
		return existingStudent;

	}

	@Override
	public void deleteAll() {
		studentRepository.deleteAll();
	}
}
/*
 * @Override public Integer saveStudent(Student student) { Student savedStudent
 * =studentRepository.save(student); return savedStudent.getId(); }
 * 
 * @Override public List<Student> getALLStudent(){ return
 * studentRepository.findALL();
 * 
 * 
 * }
 * 
 * @Override public Optional<Student> getStudent (Integer id){ return
 * studentRepository.findAll(id); }
 * 
 * @Override
 * 
 * public void deleteStudent(Integer id) { studentRepository.delete(id); }
 * 
 * @Override public Student updateStudent(Student student, Integer id) { Student
 * existingStudent = studentRepository.findBy(id).orElse(student);
 * 
 * existingStudent.setFirstName(student.getFirstName());
 * existingStudent.setLastName(student.getFirstName());
 * existingStudent.setStudentClass(student.getFirstName());
 * existingStudent.setSubject(student.getFirstName());
 * existingStudent.setFirstName(student.getFirstName());
 * studentRepository.save(existingStudent); return existingStudent; }
 * 
 * @Override public void deleteAll() { studentRepository.deleteAll(); }
 * 
 * @Override public List<Student> getAllStudents() { // TODO Auto-generated
 * method stub return null; }
 * 
 * @Override public Optional<Student> getStudent(Integer id) { // TODO
 * Auto-generated method stub return null; }
 * 
 * }
 */
