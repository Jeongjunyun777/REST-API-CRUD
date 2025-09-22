package com.example.CRUD.service;

import com.example.CRUD.dto.Request.ArticlesRequestDto;
import com.example.CRUD.dto.Response.ArticlesResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface ArticlesService {
    // 생성
    ArticlesResponseDto Createarticles(ArticlesRequestDto articlesRequestDto);
    // read
    List<ArticlesResponseDto> articlesRead();

    ArticlesResponseDto getOne(Long id);
    // update
    ArticlesResponseDto articlesUpdate(Long id, ArticlesRequestDto articlesRequestDto);
    //delete
    void articlesDelete(Long id);
}
