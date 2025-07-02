package com.gerenciador.consultas.email.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.gerenciador.consultas.config.EmailClientConfig;
import com.gerenciador.consultas.dto.EmailRequestDTO;

@FeignClient(name = "emailService", url = "${email.service.url}", configuration = EmailClientConfig.class)
public interface EmailFeignClient {

    @PostMapping("/api/email/enviar")
    ResponseEntity<String> enviarEmail(
        
        @RequestBody EmailRequestDTO dto
    );
}