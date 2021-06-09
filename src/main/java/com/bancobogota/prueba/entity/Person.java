package com.bancobogota.prueba.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@Column(name = "id_person")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "full_name")
	private String fullName;

	@Column(name = "birth")
	private LocalDate birth;
	
	@Column(name = "type_person")
	private Integer typePerson;

	public Person() {
		super();
	}

	public Person(Long id, String fullName, LocalDate birth, Integer typePerson) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.birth = birth;
		this.typePerson = typePerson;
	}

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
