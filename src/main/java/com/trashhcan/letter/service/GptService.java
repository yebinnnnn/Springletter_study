package com.trashhcan.letter.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trashhcan.letter.dto.request.GPTrequestDto;
import com.trashhcan.letter.dto.response.GPTresponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;


@Service
public class GptService {
    private final RestTemplate template;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiURL;

    public GptService(RestTemplate template){
        this.template = template;
    }

    //파일 읽어서 토픽 불러오는 메서드
    public String getRandomLetterTopic() {
        try {
            // JSON 파일 읽기
            Path filePath = new ClassPathResource("static/theme.json").getFile().toPath();
            String json = Files.readString(filePath);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            List topics = objectMapper.convertValue(rootNode.get("topics"), List.class);

            return topics.toString();
        } catch (IOException e) {
            throw new RuntimeException("JSON 파일을 읽을 수 없습니다.", e);
        }
    }


    //request 전달 Service
    public String requestGPTWithTopic() {
        String topic = getRandomLetterTopic();
        String prompt = "'" + topic +"\n '이 주제들과 비슷한 느낌의 쓸데없는 으로 시작하는 편지주제를 하나만! 반환해줘.";

        GPTrequestDto request = new GPTrequestDto(this.model, prompt);
        GPTresponseDto response = this.template.postForObject(this.apiURL, request, GPTresponseDto.class);

        return response != null ? response.getChoices().get(0).getMessage().getContent() : "응답 없음";
    }
}
