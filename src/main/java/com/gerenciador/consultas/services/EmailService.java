package com.gerenciador.consultas.services;

import com.gerenciador.consultas.dto.EmailRequestDTO;

public interface EmailService {
	void enviarEmail(EmailRequestDTO dto);

}
