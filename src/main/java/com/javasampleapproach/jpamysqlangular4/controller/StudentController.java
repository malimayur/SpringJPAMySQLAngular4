package com.javasampleapproach.jpamysqlangular4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.jpamysqlangular4.model.Student;
import com.javasampleapproach.jpamysqlangular4.repo.StudentRepository;

@RestController
@RequestMapping(value="/tcm")
public class StudentController {

	@Autowired
	StudentRepository repository;

	@GetMapping(value="/student",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAll() {
		List<Student> list = new ArrayList<>();
		Iterable<Student> students = repository.findAll();
		students.forEach(list::add);
		return list;
	}
	
	@PostMapping(value="/poststudent")
	public Student postCustomer(@RequestBody Student student) {
		Student studentObj = new Student();
		studentObj.setFirstName(student.getFirstName());
		studentObj.setLastName(student.getLastName());
		studentObj.setAddress(student.getAddress());
		studentObj.setPhone(student.getPhone());
		studentObj.setEmail(student.getEmail());
		repository.save(studentObj);
		return student;
	}

	@GetMapping(value="/findbystudentlastname/{lastName}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> findByLastName(@PathVariable String lastName) {
		List<Student> customers = repository.findByLastName(lastName);
		return customers;
	}
	
	@DeleteMapping(value="/student/{id}")
	public void deleteCustomer(@PathVariable long id){
		repository.delete(id);
	}
}
