package com.javasampleapproach.jpamysqlangular4.repo;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.jpamysqlangular4.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
}