package com.udemy.leandro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.leandro.data.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
