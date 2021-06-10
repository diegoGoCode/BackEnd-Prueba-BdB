package com.bancobogota.prueba.util;

public class MessageConstans {
	
	/**
	 * Mensaje proceso correcto API
	 */
	public static final String SUCCESS = "Proceso correcto!";
	
	/**
	 * Mensaje Error al guardar la persona
	 */
	public static final String ERROR_SAVE_PERSON = "Failed to save person";
	
	/**
	 * Mensaje Error al actualizar la persona
	 */
	public static final String ERROR_UPDATE_PERSON = "Failed to update person";
	
	/**
	 * Mensaje Persona actualizar no se encuentra
	 */
	public static final String PERSON_UPDATE_NOT_FOUND = "The person to update is not registered";
	
	/**
	 * Mensaje persona aliminar no se encuentra
	 */
	public static final String PERSON_DELETE_NOT_FOUND = "The person you want to delete is not registered";
	
	/**
	 * Mensaje el id de la persona no puede ser nulo
	 */
	public static final String PERSON_ID_NOT_NULL = "The id of the person cannot be null";
	
	/**
	 * Mensaje persona no registrada
	 */
	public static final String PERSON_NOT_FOUND = "The person is not registered";

	/**
	 * Mensaje nombre obligatorio
	 */
	public static final String NAME_REQUIRED = "The name is required";
	
	/**
	 * Mensaje fecha de nacimiento obligatoria
	 */
	public static final String BIRTH_REQUIRED = "The date of birth is mandatory";
	
	/**
	 * Mensaje tipo de persona obligatorio
	 */
	public static final String TYPE_REUIRED = "The type of person is required";
	
	
	/**
	 * Mensaje tipo de persona no reconocido
	 */
	public static final String TYPE_NOT_EXIST = "The type of person is not recognized, allowed values ​​(father, mother, child)";
}

