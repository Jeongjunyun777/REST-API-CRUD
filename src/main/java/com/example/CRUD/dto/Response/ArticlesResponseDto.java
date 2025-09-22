package com.example.CRUD.dto.Response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ArticlesResponseDto {

    private Long id;
    private String title;
    private String content;


    public ArticlesResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
