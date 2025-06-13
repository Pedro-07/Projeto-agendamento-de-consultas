package com.gerenciador.consultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.consultas.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
