package com.udemy.leandro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.udemy.leandro.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}
	
	public Person findById(String id) {
		Person person = Person.builder()
				.id(counter.incrementAndGet())
				.firstName("Leandro")
				.lastName("Reis")
				.adress("SBC - Sp - Brasil")
				.gender("Male")
				.build();
		
		return person;
	}
	
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons ;
	}

	private Person mockPerson(int i) {
		Person person = Person.builder()
				.id(counter.incrementAndGet())
				.firstName("Person name " + i)
				.lastName("Last name " + i)
				.adress("adress " + i)
				.gender("Male")
				.build();
		return person;
	}
}
