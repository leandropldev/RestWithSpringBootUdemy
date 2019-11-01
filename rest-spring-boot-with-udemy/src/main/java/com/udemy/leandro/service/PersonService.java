package com.udemy.leandro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.leandro.converters.DozerConverter;
import com.udemy.leandro.data.model.Person;
import com.udemy.leandro.data.vo.PersonVO;
import com.udemy.leandro.exception.ResourceNotFoundException;
import com.udemy.leandro.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public PersonVO create(PersonVO person) {
		Person personEntity = DozerConverter.parseObject(person, Person.class);
		return DozerConverter.parseObject(repository.save(personEntity), PersonVO.class);
	}
	
	public List<PersonVO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class); 
	}

	public PersonVO update(PersonVO person) {
		Person entity = repository.findById(person.getId())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this id: " + person.getId()));
		
			entity.setFirstName(person.getFirstName());
			entity.setLastName(person.getLastName());
			entity.setAdress(person.getAdress());
			entity.setGender(person.getGender());
		
		return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id: " + id));
		repository.delete(entity);
	}
	
	public PersonVO findById(Long id) {
		Person orElseThrow = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id: " + id));
		
		return DozerConverter.parseObject(orElseThrow, PersonVO.class);
	}
}
