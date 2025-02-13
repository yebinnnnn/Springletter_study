package com.trashhcan.letter.controller;


import com.trashhcan.letter.dto.request.GPTrequestDto;
import com.trashhcan.letter.dto.response.GPTresponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@RequestMapping("/letterbot")
public class LetterGptController {
    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public String chat(){
        String prompt="'쓸모 없는'으로 시작하는 가까운 친구에게 보낼만한 편지주제 하나만 반환해줘." +
                "예시는 다음과 같아. '쓸모없는 연말선물 추천','쓸모없는 인테리어 용품 추천' 등등이야."
                +"되도록이면 쓸모없는 다음에 오는 명사에는 취미같은 추상적인 명사가 아니었으면 좋겠고 제품같은 명사였으면 좋겠어.";
        GPTrequestDto request = new GPTrequestDto(model, prompt);
        GPTresponseDto chatGPTResponse =  template.postForObject(apiURL, request, GPTresponseDto.class);
        return Objects.requireNonNull(chatGPTResponse).getChoices().get(0).getMessage().getContent();
    }

//    @PostMapping("/chatbot")
//    public ResponseEntity<GPTresponseDto> chatBot(@RequestBody GPTpromptDto request){
//        String prompt=
//        GPTrequestDto request= new GPTrequestDto(model, prompt);
//        GPTresponseDto chatGPTResponse = template.postForObject(apiURL, request, GPTresponseDto.class);
//        return ResponseEntity.ok(chatGPTResponse);
//    }
}
