package com.yno.entityTest;

import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	@Test
	void test() {
		
		emf = Persistence.createEntityManagerFactory("01-class-and-field-mappings");
		
	}

}
