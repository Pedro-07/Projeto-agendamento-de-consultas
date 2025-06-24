package com.gerenciador.consultas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.gerenciador.consultas.email.client")
public class AgendamentoConsultasApplication {
    public static void main(String[] args) {
        SpringApplication.run(AgendamentoConsultasApplication.class, args);
    }
}
