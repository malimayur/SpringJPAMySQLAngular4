package com.javasampleapproach.jpamysqlangular4.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.jpamysqlangular4.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	List<Student> findByLastName(String lastName);
}