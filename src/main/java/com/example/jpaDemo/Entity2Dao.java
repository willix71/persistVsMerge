package com.example.jpaDemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Entity2Dao extends JpaRepository< Entity2, Long >,	JpaSpecificationExecutor< Entity2 > {
	
	Entity2 findByName(String name);
	
}
