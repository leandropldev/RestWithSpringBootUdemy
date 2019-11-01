package com.udemy.leandro.converters.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.udemy.leandro.data.model.Person;
import com.udemy.leandro.data.vo.PersonVOV2;

@Service
public class PersonConverter {

	/*
	 * o campo birthDate esta mockado, apenas para exemplicar o cenário de versinamento
	 */
	public PersonVOV2 convertEntityToVO(Person person) {
		return PersonVOV2.builder()
				.id(person.getId())
				.adress(person.getAdress())
				.birthDay(new Date())
				.firstName(person.getFirstName())
				.lastName(person.getLastName())
				.gender(person.getGender())
				.build();
	}
	
	public Person convertVOToEntity(PersonVOV2 person) {
		return Person.builder()
				.id(person.getId())
				.adress(person.getAdress())
				.firstName(person.getFirstName())
				.lastName(person.getLastName())
				.gender(person.getGender())
				.build();
	}
}
