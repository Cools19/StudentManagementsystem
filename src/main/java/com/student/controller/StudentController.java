package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.IStudentService;

@RestController
public class StudentController {

	
	@Autowired
	IStudentService studentService;
	
	 @RequestMapping("/StudentSys")
	 public String hello() {
		 return "Data Visible";
	 }

	 @PostMapping("/Student")
	 Integer createStudent(@RequestBody Student student ) {
		 Integer id =studentService.saveStudent(student);
		 System.out.println(id);
		 return id;
	 }
	 
	 @GetMapping("/allstudent")
	 public List<Student> getBook(){
		 return studentService.getAllStudents();
	 }
	 
	 @DeleteMapping("/deletestudent")
	 public String deleteAllStudent(){
		studentService.deleteAll();
		return "Deleted all student";
	 }
		 
		 
	 @GetMapping("/getstudent/{id}")
	 public Optional<Student> getEmployee(@PathVariable Integer id){
		 Optional<Student> employee = studentService.getStudent(id);
		 return employee; 
	 }
	 
	 @DeleteMapping ("/deletestudent/{id}")
	 public ResponseEntity<Student> deleteStudent(@PathVariable Integer id){
		 System.out.println(id);
		 ResponseEntity<Student> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		 
				 try {
					 studentService.deleteStudent(id);
				 }
		 		catch(Exception e) {
		 			e.printStackTrace();
		 			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 		}
		 return responseEntity;
	 }
	 
	 @PutMapping("/updatestudent/{id}")
	 public ResponseEntity<Student> upadtestudent(@PathVariable("id") Integer id, @RequestBody Student student){
		 return new ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK);
		 
	 }
	 
	 
	 
	}
	
	


