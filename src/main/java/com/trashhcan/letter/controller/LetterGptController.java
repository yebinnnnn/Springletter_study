package com.trashhcan.letter.controller;


import com.trashhcan.letter.dto.request.GPTrequestDto;
import com.trashhcan.letter.dto.response.GPTresponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    public String chat(@RequestParam(name = "prompt")String prompt){
        GPTrequestDto request = new GPTrequestDto(model, prompt);
        GPTresponseDto chatGPTResponse =  template.postForObject(apiURL, request, GPTresponseDto.class);
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }
}
