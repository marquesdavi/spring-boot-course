package com.davi.contentcalendar.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyWebConfig {
    /*
        When the @Bean anotation is added, the method becomes a Bean
    */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().build();
    }
}
