package com.javasampleapproach.jpamysqlangular4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.jpamysqlangular4.model.Subject;
import com.javasampleapproach.jpamysqlangular4.repo.SubjectRepository;

@RestController
@RequestMapping(value = "/tcm")
public class SubjectController {

	@Autowired
	SubjectRepository repository;

	@GetMapping(value = "/subject", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Subject> getAll() {
		List<Subject> list = new ArrayList<>();
		Iterable<Subject> students = repository.findAll();
		students.forEach(list::add);
		return list;
	}
}
