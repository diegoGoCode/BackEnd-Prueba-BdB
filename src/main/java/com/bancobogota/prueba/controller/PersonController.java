package com.bancobogota.prueba.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bancobogota.prueba.dto.PersonDTO;
import com.bancobogota.prueba.exception.ServiceException;
import com.bancobogota.prueba.service.PersonService;
import com.bancobogota.prueba.util.ApiError;
import com.bancobogota.prueba.util.GeneralResponse;
import com.bancobogota.prueba.util.MessageConstans;


@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GeneralResponse<List<PersonDTO>>> getPersons(){
		GeneralResponse<List<PersonDTO>> response = new GeneralResponse<List<PersonDTO>>();
		HttpStatus status = HttpStatus.OK;
		try {
			List<PersonDTO> listPerson = personService.getPersons();
			response.setData(listPerson);
			response.setSuccess(true);
			response.setMessage(MessageConstans.SUCCESS);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setApiError(new ApiError("Error al obtener las personas"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<GeneralResponse<List<PersonDTO>>>(response, status);
	}
	
	@GetMapping(value = "/{idPerson}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GeneralResponse<PersonDTO>> getPerson(@PathVariable Long idPerson){
		GeneralResponse<PersonDTO> response = new GeneralResponse<PersonDTO>();
		HttpStatus status = HttpStatus.OK;
		try {
			PersonDTO person = personService.getPerson(idPerson);
			response.setData(person);
			response.setSuccess(true);
			response.setMessage(MessageConstans.SUCCESS);
		} catch (ServiceException  e) {
			response.setSuccess(false);
			response.setApiError(e.getApiError());
			status = HttpStatus.BAD_REQUEST;
		}catch (Exception e) {
			response.setSuccess(false);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<GeneralResponse<PersonDTO>>(response, status);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GeneralResponse<PersonDTO>> savePerson(@RequestBody PersonDTO personDto){
		GeneralResponse<PersonDTO> response = new GeneralResponse<PersonDTO>();
		HttpStatus status = HttpStatus.OK;
		try {
			PersonDTO person = personService.saveOrUpdatePerson(personDto);
			response.setData(person);
			response.setSuccess(true);
			response.setMessage(MessageConstans.SUCCESS);
		} catch (ServiceException  e) {
			response.setSuccess(false);
			response.setApiError(e.getApiError());
			status = HttpStatus.BAD_REQUEST;
		}catch (Exception e) {
			response.setSuccess(false);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<GeneralResponse<PersonDTO>>(response, status);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GeneralResponse<PersonDTO>> updatePerson(@RequestBody PersonDTO personDto){
		GeneralResponse<PersonDTO> response = new GeneralResponse<PersonDTO>();
		HttpStatus status = HttpStatus.OK;
		try {
			PersonDTO person = personService.saveOrUpdatePerson(personDto);
			response.setData(person);
			response.setSuccess(true);
			response.setMessage(MessageConstans.SUCCESS);
		} catch (ServiceException  e) {
			response.setSuccess(false);
			response.setApiError(e.getApiError());
			status = HttpStatus.BAD_REQUEST;
		}catch (Exception e) {
			response.setSuccess(false);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<GeneralResponse<PersonDTO>>(response, status);
	}
	
	@DeleteMapping(value = "/{idPerson}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GeneralResponse<Boolean>> deletePerson(@PathVariable Long idPerson){
		GeneralResponse<Boolean> response = new GeneralResponse<Boolean>();
		HttpStatus status = HttpStatus.OK;
		try {
			personService.deletePersonById(idPerson);
			response.setSuccess(true);
			response.setMessage(MessageConstans.SUCCESS);
		} catch (ServiceException  e) {
			response.setSuccess(false);
			response.setApiError(e.getApiError());
			status = HttpStatus.BAD_REQUEST;
		}catch (Exception e) {
			response.setSuccess(false);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<GeneralResponse<Boolean>>(response, status);
	}
	
	

}
