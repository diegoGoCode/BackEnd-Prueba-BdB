package com.bancobogota.prueba.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bancobogota.prueba.converter.PersonToDtoConverter;
import com.bancobogota.prueba.dto.PersonDTO;
import com.bancobogota.prueba.entity.Person;
import com.bancobogota.prueba.exception.ServiceException;
import com.bancobogota.prueba.repository.PersonRepository;
import com.bancobogota.prueba.util.ApiError;
import com.bancobogota.prueba.util.MessageConstans;
import com.bancobogota.prueba.util.ValidatorUtil;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PersonToDtoConverter personToDtoConverter;
	
	@Autowired
	private ValidatorUtil validatorUtil;
	
	private static final Integer TYPE_FATHER = 1;
	private static final Integer TYPE_MOTHER = 2;
	private static final Integer TYPE_CHILDREN = 3;

	@Override
	public List<PersonDTO> getPersons() throws ServiceException {
		List<Person> personList = personRepository.findAllPersons();
		return personList.stream().map(personToDtoConverter::convert).collect(Collectors.toList());
	}

	@Override
	public PersonDTO getPerson(Long idPerson) throws ServiceException{
		validatorUtil.validateIdPerson(idPerson);
		Person person = personRepository.findById(idPerson).orElse(null);
		validatorUtil.validatePersonByIdNull(person);
		return personToDtoConverter.convert(person);
	}

	@Override
	public PersonDTO saveOrUpdatePerson(PersonDTO personDto) throws ServiceException {
		validatePerson(personDto);
		Person persona = null;
		try {
			if(personDto.getId() != null) {
				persona = personRepository.findById(personDto.getId()).orElse(null);
				if(persona == null) {
					throw new ServiceException(new ApiError(MessageConstans.PERSON_UPDATE_NOT_FOUND));
				}
				persona.setFullName(personDto.getFullName());
				persona.setBirth(personDto.getBirth());
				persona.setTypePerson(personDto.getTypePerson());
			}else {
				persona = personToDtoConverter.convertToEntity(personDto);
			}
			persona = personRepository.save(persona);
			personDto = personToDtoConverter.convert(persona);
			
		} catch (ServiceException e) {
			throw new ServiceException(new ApiError(MessageConstans.PERSON_UPDATE_NOT_FOUND));
		} catch (Exception e) {
			if(personDto.getId() != null) {
				throw new ServiceException(new ApiError(MessageConstans.ERROR_UPDATE_PERSON));
			}else {
				throw new ServiceException(new ApiError(MessageConstans.ERROR_SAVE_PERSON));
			}
		}
		return personDto;
	}

	@Override
	public void deletePersonById(Long idPerson) throws ServiceException{
		validatorUtil.validateIdPerson(idPerson);
		Person person = personRepository.findById(idPerson).orElseThrow(() -> new ServiceException(new ApiError(MessageConstans.PERSON_DELETE_NOT_FOUND)));
		personRepository.delete(person);
	}
	
	public void validatePerson(PersonDTO personDto) throws ServiceException{
		if(personDto.getFullName() == null || personDto.getFullName() == "") {
			throw new ServiceException(new ApiError(MessageConstans.NAME_REQUIRED));
		}
		if(personDto.getBirth() == null) {
			throw new ServiceException(new ApiError(MessageConstans.BIRTH_REQUIRED));
		}
		if(personDto.getTypePerson() == null) {
			throw new ServiceException(new ApiError(MessageConstans.TYPE_REUIRED));
		}
		if(personDto.getTypePerson() != TYPE_FATHER && personDto.getTypePerson() != TYPE_MOTHER && personDto.getTypePerson() != TYPE_CHILDREN) {
			throw new ServiceException(new ApiError(MessageConstans.TYPE_NOT_EXIST));
		}
	}
	
	
}
