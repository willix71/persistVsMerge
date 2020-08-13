package com.example.jpaDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}
	
	@Bean
	public Object init(StoreService store) {
		store.runInTransaction(entityManager -> {
			System.out.println("Inserting some values...");
			Entity1 eu1 = new Entity1("eu1"); 
			entityManager.persist(eu1);
			new Entity2("eu2", eu1);
		});
		return new Object();
	}
}
