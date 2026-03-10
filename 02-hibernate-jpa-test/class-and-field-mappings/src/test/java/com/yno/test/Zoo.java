package com.yno.test;

import org.junit.jupiter.api.Test;

import com.yno.Animal;
import com.yno.AnimalInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Zoo {
	
	EntityManagerFactory emF;
	EntityManager em;
	
	@Test
	void test() {
		
		emF = Persistence.createEntityManagerFactory("class-and-field-mappings");
		em = emF.createEntityManager();
		
		var animalinfo = new AnimalInfo();
		animalinfo.setAbility("Monkey Dance");
		animalinfo.setDescription("Monkey is animal.");
		animalinfo.setFood("Banana");
		
		Animal animal = new Animal();
		animal.setName("Monkey");
		animal.setInfo(animalinfo);
		
		em.getTransaction().begin();;
		em.persist(animal);
		em.getTransaction().commit();
		
	}

}
