package com.bancobogota.prueba.util;

import org.springframework.stereotype.Component;
import com.bancobogota.prueba.exception.ServiceException;

@Component
public class ValidatorUtil {
	
	public void validateIdPerson(Long idPerson) throws ServiceException {
		if(idPerson == null) {
			throw new ServiceException(new ApiError(MessageConstans.PERSON_ID_NOT_NULL));
		}
	}
	
	public void validatePersonByIdNull(Object object) throws ServiceException{
		if(object == null) {
			throw new ServiceException(new ApiError(MessageConstans.PERSON_NOT_FOUND));
		}
	}

}
