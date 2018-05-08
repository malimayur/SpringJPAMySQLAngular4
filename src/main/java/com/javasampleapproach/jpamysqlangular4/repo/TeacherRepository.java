package com.javasampleapproach.jpamysqlangular4.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.jpamysqlangular4.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
	List<Teacher> findByLastName(String lastName);
}