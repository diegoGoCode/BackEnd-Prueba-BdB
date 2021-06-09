package com.bancobogota.prueba.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bancobogota.prueba.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	@Query(value = "SELECT p FROM Person p ORDER BY p.id DESC")
	public List<Person> findAllPersons();
}
