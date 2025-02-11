package com.trashhcan.letter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//RESTtemplate bean 으로 등록함.
@Configuration
public class Openaiconfig {
    @Value("${openai.api.key}")
    private String openAiKey;

    @Bean //HTTP 요청을 하고, 응답을 받는 동기식 시스템
    public RestTemplate template(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openAiKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}
