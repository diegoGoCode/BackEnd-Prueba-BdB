package com.bancobogota.prueba.converter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bancobogota.prueba.dto.PersonDTO;
import com.bancobogota.prueba.entity.Person;

@Component
public class PersonToDtoConverter implements Converter<Person, PersonDTO>{

	@Override
	public PersonDTO convert(Person source) {
		if(source == null)
			return null;
		
		PersonDTO dto = new PersonDTO();
		dto.setId(source.getId());
		dto.setFullName(source.getFullName());
		dto.setBirth(source.getBirth());
		dto.setTypePerson(source.getTypePerson());
		return dto;
	}
	
	public Person convertToEntity(PersonDTO dto) {
		if(dto == null)
			return null;
		
		Person person = new Person();
		person.setFullName(dto.getFullName());
		person.setBirth(dto.getBirth());
		person.setTypePerson(dto.getTypePerson());
		return person;
	}

}
