package com.gerenciador.consultas.services;

import java.util.List;

import com.gerenciador.consultas.model.Medico;

public interface MedicoService {
	
	Medico cadastrar (Medico medico);

	List<Medico> listarTodos();
	
	void excluir (Long id);
}
