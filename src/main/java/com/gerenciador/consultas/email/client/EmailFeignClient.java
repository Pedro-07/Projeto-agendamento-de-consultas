package com.gerenciador.consultas.email.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.gerenciador.consultas.dto.EmailRequestDTO;

@FeignClient(name = "emailService", url = "${email.api-url}")
public interface EmailFeignClient {

    @PostMapping("/api/email/enviar")
    ResponseEntity<String> enviarEmail(
        @RequestHeader("X-API-KEY") String apiKey,
        @RequestBody EmailRequestDTO dto
    );
}