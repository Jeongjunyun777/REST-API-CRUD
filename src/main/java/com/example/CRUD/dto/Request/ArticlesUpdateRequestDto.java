package com.example.CRUD.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticlesUpdateRequestDto {

    private String id;
    private String title;
    private String content;
}
