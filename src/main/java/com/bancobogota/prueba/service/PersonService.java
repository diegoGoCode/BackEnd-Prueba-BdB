package com.bancobogota.prueba.service;

import java.text.ParseException;
import java.util.List;
import com.bancobogota.prueba.dto.PersonDTO;
import com.bancobogota.prueba.exception.ServiceException;

public interface PersonService {
	public List<PersonDTO> getPersons() throws ServiceException;
	public PersonDTO getPerson(Long idPerson) throws ServiceException;
	public PersonDTO saveOrUpdatePerson(PersonDTO personDto) throws ServiceException, ParseException;
	public void deletePersonById(Long idPerson) throws ServiceException;
}
