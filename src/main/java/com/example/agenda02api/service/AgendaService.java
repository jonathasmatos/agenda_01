package com.example.agenda02api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.agenda02api.model.Agenda;
import com.example.agenda02api.repository.AgendaRepository;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository repository;
	
	public Agenda create(Agenda obj) {
		return repository.save(obj);
	}
	
	public Agenda update(Agenda obj) {
		Agenda objSaved = findById(obj.getId());

		BeanUtils.copyProperties(obj, objSaved, "id");

		return repository.save(objSaved);
	}
	
	public List<Agenda> findAll() {
		return repository.findAll();
	}
	
	public List<Agenda> findByStatus(Boolean status) {
		return repository.findByStatus(status);
	}
	
	public Agenda findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public void changeStatus(Long id) {
		Agenda obj = findById(id);
		Boolean status = !obj.getStatus();
		obj.setStatus(status);
		repository.save(obj);
	}
}
