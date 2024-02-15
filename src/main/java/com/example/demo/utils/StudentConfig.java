package com.example.demo.utils;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Student API")
                        .description("Ejemplo API REST")
                        .contact(new Contact()
                                .name("Hermes Pérez Parrondo")
                                .email("herperpar@alu.edu.gva.es")
                                .url("https://linkhpp.github.io/")
                        )
                        .version("1.0"));
    }
}
