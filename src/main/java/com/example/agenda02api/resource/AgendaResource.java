package com.example.agenda02api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.agenda02api.model.Agenda;
import com.example.agenda02api.service.AgendaService;

import jakarta.validation.Valid;

@RequestMapping("/agenda")
@RestController
public class AgendaResource {

	
	@Autowired
	private AgendaService service;
	
	private String requestMapping = "/agenda"; 
	
	
	@GetMapping
	public List<Agenda> findAll() {
		List<Agenda> list = service.findAll();
		return list;
	}
	
	@GetMapping("/status/{status}")
	public List<Agenda> findByStatus(@PathVariable Boolean status) {
		List<Agenda> list = service.findByStatus(status);
		return list;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Agenda> findById(@PathVariable Long id) {
		Agenda objSaved = service.findById(id);
		return ResponseEntity.ok(objSaved);
	}
	
	@PostMapping
	public ResponseEntity<Agenda> create(@RequestBody @Valid Agenda obj) {
		Agenda objSaved = service.create(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(objSaved);
	}
	
	@PutMapping
	public ResponseEntity<Agenda> update(@RequestBody @Valid Agenda obj) {
		Agenda objSaved = service.update(obj);
		return ResponseEntity.ok(objSaved);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	@PutMapping("/status/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<Agenda> changeStatus(@PathVariable Long id) {
		Agenda objSaved = service.changeStatus(id);
		return ResponseEntity.ok(objSaved);
	}

	public String getRequestMapping() {
		return requestMapping;
	}

	public void setRequestMapping(String requestMapping) {
		this.requestMapping = requestMapping;
	}
}
