package com.example.agenda02api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agenda02api.model.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

	List<Agenda> findByStatus(Boolean status);
}
