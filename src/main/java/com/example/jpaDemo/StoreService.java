package com.example.jpaDemo;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

	@Autowired
	Entity1Dao dao1;
	
	@Autowired
	Entity2Dao dao2;

	@Autowired 
	EntityManager entityManager;
	
	public Entity1 loadEntity1ByName(String name) {
		return dao1.findByName(name);
	}
	
	public Entity2 loadEntity2ByName(String name) {
		return dao2.findByName(name);
	}

	@Transactional
	public void runInTransaction(Consumer<EntityManager> doThis) {
		doThis.accept(entityManager);
	}

	@Transactional
	public Entity1 saveEntity1(Entity1 e) {
		return dao1.save(e);
	}

	@Transactional
	public Entity2 saveEntity2(Entity2 e) {
		return dao2.save(e);
	}

}
