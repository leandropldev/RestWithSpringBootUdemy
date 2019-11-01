package com.udemy.leandro.converters;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.udemy.leandro.data.model.Person;
import com.udemy.leandro.data.vo.PersonVO;
import com.udemy.leandro.mock.MockPerson;


public class DozerConverterTest {
	
	private MockPerson inputObject;
	
	@Before
	public void init() {
		inputObject = new MockPerson();
	}
	
	@Test
	public void parteEntitToVOTest() {
		PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
		Assert.assertEquals(Long.valueOf(0L), output.getId());
		Assert.assertEquals("Mock first name 0", output.getFirstName());
	}
	
	@Test
	public void parseEntityListToVOTest() {
		List<PersonVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
		
		PersonVO outputList0 = outputList.get(0);
		Assert.assertEquals(Long.valueOf(0L), outputList0.getId());
		Assert.assertEquals("Mock first name 0", outputList0.getFirstName());

		PersonVO outputList5 = outputList.get(5);
		Assert.assertEquals(Long.valueOf(5L), outputList5.getId());
		Assert.assertEquals("Mock first name 5", outputList5.getFirstName());

		PersonVO outputList10 = outputList.get(10);
		Assert.assertEquals(Long.valueOf(10L), outputList10.getId());
		Assert.assertEquals("Mock first name 10", outputList10.getFirstName());
	}
	
	@Test
	public void parseVOtoEntityTest() {
		Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
		Assert.assertEquals(Long.valueOf(0L), output.getId());
		Assert.assertEquals("Mock first name 0", output.getFirstName());
	}
	
	@Test
	public void parseVOListToEntityListTest() {
		List<Person> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Person.class);
		
		Person outputList0 = outputList.get(0);
		Assert.assertEquals(Long.valueOf(0L), outputList0.getId());
		Assert.assertEquals("Mock first name 0", outputList0.getFirstName());

		Person outputList5 = outputList.get(5);
		Assert.assertEquals(Long.valueOf(5L), outputList5.getId());
		Assert.assertEquals("Mock first name 5", outputList5.getFirstName());

		Person outputList10 = outputList.get(10);
		Assert.assertEquals(Long.valueOf(10L), outputList10.getId());
		Assert.assertEquals("Mock first name 10", outputList10.getFirstName());
	}
}
