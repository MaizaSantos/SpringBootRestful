package br.com.maizasantos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.maizasantos.model.Person;

//Sinaliza para o Spring Boot um objeto que vai ser injetado em runtime em outras classes da aplicação
@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public Person create(Person person) {
		logger.info("Creating one person!");
		
		person.setId(counter.incrementAndGet());
		
		return person;
	}
	
	public List<Person> findAll() {
		logger.info("Finding all people!");
		
		List<Person> people = new ArrayList<>(); 
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			people.add(person);
		}
		
		return people;
	}

	public Person findById(String id) {
		logger.info("Finding one person!");
		
		Person person = new Person();
		
		//Mock
		person.setId(counter.incrementAndGet());
		person.setFirstName("Maíza");
		person.setLastName("Santos");
		person.setAddress("São Paulo - Brasil");
		person.setGender("Female");
		
		return person;
	}
	
	public Person update(String id, Person person) {
		logger.info("Updating one person!");
		
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one person!");
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name: " + i);
		person.setLastName("Last name: " + i);
		person.setAddress("Some address in Brazil");
		person.setGender("Female");
		
		return person;
	}
	
}
