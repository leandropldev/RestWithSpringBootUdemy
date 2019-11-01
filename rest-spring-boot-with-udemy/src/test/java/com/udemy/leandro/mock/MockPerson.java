package com.udemy.leandro.mock;

import java.util.ArrayList;
import java.util.List;

import com.udemy.leandro.data.model.Person;
import com.udemy.leandro.data.vo.PersonVO;

public class MockPerson {

	public Person mockEntity() {
		return mockEntity(0);
	}
	
	public PersonVO mockVO() {
		return mockVO(0);
	}
	
	public List<Person> mockEntityList(){
		List<Person> list = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			list.add(mockEntity(i));
		}
		return list;
	}
	
	public List<PersonVO> mockVOList(){
		List<PersonVO> list = new ArrayList<>();
		for (int i = 0; i <= 10 ; i++) {
			list.add(mockVO(i));
		}
		return list;
	}
	
	private Person mockEntity(Integer number) {
		return Person.builder()
				.id(number.longValue())
				.firstName("Mock first name " + number)
				.lastName("Mock last name " + number)
				.gender( "Mock gender " + number)
				.adress("Mock address " + number)
				.build();
	}
	
	private PersonVO mockVO(Integer number) {
		return PersonVO.builder()
				.id(number.longValue())
				.firstName("Mock first name " + number)
				.lastName("Mock last name " + number)
				.gender("Mock gender " + number)
				.adress("Mock adress " + number)
				.build();
	}
}
