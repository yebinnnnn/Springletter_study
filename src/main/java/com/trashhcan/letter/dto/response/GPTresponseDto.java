package com.trashhcan.letter.dto.response;


import com.trashhcan.letter.dto.request.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GPTresponseDto {
    private List<Choice> choices;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Choice{
        private int index;
        private Message message;
    }
}
