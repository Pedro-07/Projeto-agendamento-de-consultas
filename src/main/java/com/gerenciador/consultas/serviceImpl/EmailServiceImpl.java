package com.gerenciador.consultas.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gerenciador.consultas.dto.EmailRequestDTO;
import com.gerenciador.consultas.email.client.EmailFeignClient;
import com.gerenciador.consultas.services.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${email.api-key}")
    private String apiKey;

    private final EmailFeignClient emailClient;

    public EmailServiceImpl(EmailFeignClient emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public void enviarEmail(EmailRequestDTO dto) {
        emailClient.enviarEmail(apiKey, dto);
    }
}
