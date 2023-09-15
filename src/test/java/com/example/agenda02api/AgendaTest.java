package com.example.agenda02api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.agenda02api.model.Agenda;
import com.example.agenda02api.service.AgendaService;

@SpringBootTest
public class AgendaTest {
	
	@Autowired
	private AgendaService service;
	
	@Test
	public void contextLoads() {
		Agenda obj = create();
		obj = update(obj);
		delete(obj);
	}
	
	public Agenda create() {
	Agenda obj = new Agenda();

	obj.setName("Jhow");
	obj.setContact("9198999556");
	obj.setStatus(true);
	
	return service.create(obj);

//	Agenda objSaved = service.create(obj);
//	obj.setId(objSaved.getId());
//
//	assertThat(objSaved).isEqualTo(obj);
//
//	return objSaved;
}

	
	public Agenda update(Agenda obj) {
		
	obj.setName("Eliwelton");

	Agenda objSaved = service.update(obj);

	assertThat(objSaved).isEqualTo(obj);

	return objSaved;

}
	
	public void delete(Agenda obj) {
		service.delete(obj.getId());
	}

}