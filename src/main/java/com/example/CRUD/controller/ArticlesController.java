package com.example.CRUD.controller;

import com.example.CRUD.dto.Request.ArticlesRequestDto;
import com.example.CRUD.dto.Response.ArticlesResponseDto;
import com.example.CRUD.service.ArticlesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article/v1")
public class ArticlesController {

    private final ArticlesServiceImpl articlesServiceImpl;

    @PostMapping
    public ResponseEntity<ArticlesResponseDto> createArticle(@RequestBody ArticlesRequestDto articlesRequestDto) {
        ArticlesResponseDto articlesResponseDto = articlesServiceImpl.Createarticles(articlesRequestDto);
        return ResponseEntity.status(201).body(articlesResponseDto);
    }
    @GetMapping
    public ResponseEntity<ArticlesResponseDto> getArticles() {
        List<ArticlesResponseDto> articlesResponseDtos = articlesServiceImpl.articlesRead();
        return ResponseEntity.ok((ArticlesResponseDto) articlesResponseDtos);

    }
    @GetMapping("/{article_id}")
    public ResponseEntity<ArticlesResponseDto> getOne(@PathVariable("article_id") Long id){
        ArticlesResponseDto response = articlesServiceImpl.getOne(id);
        return ResponseEntity.ok(response);
    }
    @PatchMapping("/{article_id}")
    public ResponseEntity<ArticlesResponseDto> updateArticles(
            @PathVariable("article_id") Long id, @RequestBody ArticlesRequestDto articlesRequestDto) {
        ArticlesResponseDto update =articlesServiceImpl.articlesUpdate(id, articlesRequestDto);
        return ResponseEntity.ok(update);
    }
    @DeleteMapping("/{articles_id}")
    public ResponseEntity<Void> deleteArticles(@PathVariable("articles_id") Long id){
        articlesServiceImpl.articlesDelete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
