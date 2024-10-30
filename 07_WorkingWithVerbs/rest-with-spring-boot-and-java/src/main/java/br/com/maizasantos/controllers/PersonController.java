package br.com.maizasantos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maizasantos.model.Person;
import br.com.maizasantos.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	//Spring Boot faz a instanciação de forma dinâmica em tempo de execução
	@Autowired
	private PersonServices personService;

	@PostMapping
	public ResponseEntity<Person> create(@RequestBody Person person) {
		person = personService.create(person);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public List<Person> findAll() {
		return personService.findAll();
	}

	@GetMapping("/{id}")
	public Person findById(@PathVariable(value = "id") String id) {
		return personService.findById(id);
	}
	
	@PutMapping("/{id}")
	public Person update(@PathVariable String id, @RequestBody Person person) {
		return personService.update(id, person);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") String id) {
		personService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
