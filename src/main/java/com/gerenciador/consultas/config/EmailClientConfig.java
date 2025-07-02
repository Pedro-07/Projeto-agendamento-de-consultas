package com.gerenciador.consultas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class EmailClientConfig {
    @Bean
    public RequestInterceptor apiKeyInterceptor() {
        return template -> {
            template.header("X-API-KEY", "1b08e28140ed88e76c9910162c3deae5");
        };
    }
}
