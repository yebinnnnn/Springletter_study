package com.trashhcan.letter.dto.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GPTrequestDto { //GPT에 request 보내는 클래스
    private String model;
    private List<Message> messages;

    public GPTrequestDto(String model, String prompt) { //생성자
        this.model = model;
        this.messages =  new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }
}
