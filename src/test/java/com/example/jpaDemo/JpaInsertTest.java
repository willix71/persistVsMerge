package com.example.jpaDemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class JpaInsertTest {

	@Autowired
	StoreService store;
	
	@BeforeEach
	public void startTest(TestInfo info) {
		System.out.println("\n---- Running " + info.getDisplayName());
	}
	
	@AfterEach
	public void endTest(TestInfo info) {
		System.out.println("---- Done " + info.getDisplayName() + "\n");
	}
	
	@Test
	@Order(1)
	void test1_insertEntity2_WithNewEntity1() {
		store.saveEntity2(new Entity2("e2-1", new Entity1("e1-1")));
		
		assertThat(store.loadEntity1ByName("e1-1")).as("e1-1").isNotNull();
		assertThat(store.loadEntity2ByName("e2-1")).as("e2-1").isNotNull();
	}
	
	@Test
	@Order(2)
	void test2_insertEntity2_WithExistingEntity1() {
		store.saveEntity2(new Entity2("e2-2", store.saveEntity1(new Entity1("e1-2"))));
		
		assertThat(store.loadEntity1ByName("e1-2")).as("e1-2").isNotNull();
		assertThat(store.loadEntity2ByName("e2-2")).as("e2-2").isNotNull();
	}
	
	@Test
	@Order(3)
	void test3_insertEntity1_WithNewEntity2() {
		store.saveEntity1(new Entity1("e1-3").addEntity2(new Entity2("e2-3")));
		
		assertThat(store.loadEntity1ByName("e1-3")).as("e1-3").isNotNull();
		assertThat(store.loadEntity2ByName("e2-3")).as("e2-3").isNotNull();
	}
	
	@Test
	@Order(4)
	void test4_insertEntity1_WithExistingEntity2() {
		store.saveEntity1(new Entity1("e1-4").addEntity2(store.saveEntity2(new Entity2("e2-4"))));
		
		assertThat(store.loadEntity1ByName("e1-4")).as("e1-4").isNotNull();
		assertThat(store.loadEntity2ByName("e2-4")).as("e2-4").isNotNull();
	}
}
