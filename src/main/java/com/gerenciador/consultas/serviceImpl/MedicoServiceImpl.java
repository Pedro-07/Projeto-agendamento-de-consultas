package com.gerenciador.consultas.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerenciador.consultas.model.Medico;
import com.gerenciador.consultas.repository.MedicoRepository;
import com.gerenciador.consultas.services.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {
	
	private final MedicoRepository repository;
	
	public MedicoServiceImpl(MedicoRepository repository) {
		this.repository = repository;
	}
	

	@Override
	public Medico cadastrar(Medico medico) {
		
		return repository.save(medico);
	}

	@Override
	public List<Medico> listarTodos() {
		
		return repository.findAll();
	}
	
	@Override
	public void excluir(Long id) {
		Medico medico = repository.findById(id)
				.orElseThrow(()-> new RuntimeException("Médico não encontrado"));
		repository.delete(medico);
	}
	


}
