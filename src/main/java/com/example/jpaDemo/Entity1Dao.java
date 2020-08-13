package com.example.jpaDemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Entity1Dao extends JpaRepository< Entity1, Long >,	JpaSpecificationExecutor< Entity1 > {
	
	Entity1 findByName(String name);
}


