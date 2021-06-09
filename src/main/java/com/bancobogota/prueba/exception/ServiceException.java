package com.bancobogota.prueba.exception;

import java.io.Serializable;
import java.util.List;

import com.bancobogota.prueba.util.ApiError;

public class ServiceException extends Exception implements Serializable {
	/** * */
	private static final long serialVersionUID = 1L;

	public ServiceException() {
	}

	/**
	 * Informacion del error
	 */
	private ApiError apiError;

	/**
	 * Informacion del error
	 */
	private List<ApiError> apiErrorList;

	/**
	 * Constructor
	 * 
	 * @param text
	 * @param e
	 */
	public ServiceException(String text, Exception e) {
		super(text, e);
	}

	/**
	 * Constructor
	 * 
	 * @param text
	 */
	public ServiceException(String text) {
		super(text);
	}

	/**
	 * Constructor
	 * 
	 * @param text
	 */
	public ServiceException(ApiError apiError) {
		super(apiError.getMessageUser());
		this.apiError = apiError;
	}

	public ServiceException(ApiError apiError, String message) {
		super(message);
		this.apiError = apiError;
	}

	public ApiError getApiError() {
		return apiError;
	}

	public List<ApiError> getApiErrorList() {
		return apiErrorList;
	}

	public void setApiErrorList(List<ApiError> apiErrorList) {
		this.apiErrorList = apiErrorList;
	}

	public void setApiError(ApiError apiError) {
		this.apiError = apiError;
	}
}
