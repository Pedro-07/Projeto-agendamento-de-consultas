package com.gerenciador.consultas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.consultas.model.Medico;
import com.gerenciador.consultas.repository.MedicoRepository;
import com.gerenciador.consultas.services.MedicoService;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {
	
	private final MedicoService medicoService;
	private final MedicoRepository medicoRepository;
	
	public MedicoController(MedicoService medicoService, MedicoRepository medicoRepository) {
		this.medicoService = medicoService;
		this.medicoRepository = medicoRepository;
	}
	
	@PostMapping
	public ResponseEntity<Medico> cadastrar(@RequestBody Medico medico) {
		Medico medicoSalvo = medicoService.cadastrar(medico);
		return ResponseEntity.status(HttpStatus.CREATED).body(medicoSalvo);
	}
	
	@GetMapping
	public ResponseEntity<List<Medico>> listarTodos() {
		List<Medico> medicos = medicoService.listarTodos();
		return ResponseEntity.ok(medicos);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluir(@PathVariable Long id) {
		medicoService.excluir(id);
		return ResponseEntity.ok("Médico excluído da lista");
	}
}
