package com.trashhcan.letter.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponseDto {
    private String type;
    private List<String> images;
}
