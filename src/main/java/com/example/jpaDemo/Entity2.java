package com.example.jpaDemo;

import static javax.persistence.CascadeType.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true) @Getter @Setter  @NoArgsConstructor @RequiredArgsConstructor
@Entity
public class Entity2 extends AbstractEntity {

	@NonNull
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ALL})
	private Entity1 entity1;

	public Entity2(@NonNull String name, Entity1 entity1) {
		this.name = name;
		entity1.addEntity2(this);
	}
}
