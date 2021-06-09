package com.bancobogota.prueba.util;

import java.io.Serializable;

public class ApiError implements Serializable{
	/** * */
	private static final long serialVersionUID = 1L;

	/**
	 * Mensaje de error mostrado al usuario
	 */
	private String messageUser;

	/**
	 * Constructor
	 */
	public ApiError() {
	}

	public ApiError(String messageUser) {
		super();
		this.messageUser = messageUser;
	}

	public String getMessageUser() {
		return messageUser;
	}

	public void setMessageUser(String messageUser) {
		this.messageUser = messageUser;
	}
}
