package com.example.jpaDemo;

import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true) @Getter @Setter  @NoArgsConstructor @RequiredArgsConstructor
@Entity
public class Entity1 extends AbstractEntity {

	@NonNull
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "entity1", cascade = {ALL}, orphanRemoval = true)	
	private List<Entity2> entities2;
	
	public Entity1 addEntity2(Entity2 e2) {
		if (entities2 == null) entities2=new ArrayList<>();
		entities2.add(e2);
		e2.setEntity1(this);
		return this;
	}
}
