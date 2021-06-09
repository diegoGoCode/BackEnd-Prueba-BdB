package com.bancobogota.prueba.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PersonDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String fullName;
	private LocalDate birth;
	private Integer typePerson;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	public Integer getTypePerson() {
		return typePerson;
	}
	public void setTypePerson(Integer typePerson) {
		this.typePerson = typePerson;
	}
}
