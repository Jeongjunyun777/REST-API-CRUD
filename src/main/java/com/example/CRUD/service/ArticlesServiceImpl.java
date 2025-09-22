package com.example.CRUD.service;

import com.example.CRUD.dto.Request.ArticlesRequestDto;
import com.example.CRUD.dto.Response.ArticlesResponseDto;
import com.example.CRUD.entity.Articles;
import com.example.CRUD.repository.ArticlesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticlesServiceImpl implements ArticlesService {

    private final ArticlesRepository articlesRepository;

    @Override
    @Transactional
    public ArticlesResponseDto Createarticles(ArticlesRequestDto articlesRequestDto) {
        if (articlesRequestDto.getContent() == null || articlesRequestDto.getTitle() == null) {
            throw new IllegalArgumentException("제목과 내용은 비어있을수없습니다.");
        }
        Articles article = Articles.builder()
                .title(articlesRequestDto.getTitle())
                .content(articlesRequestDto.getContent())
                .build();

        Articles saved = articlesRepository.save(article);

        ArticlesResponseDto articlesResponseDto = new ArticlesResponseDto(
                saved.getId(),
                saved.getTitle(),
                saved.getContent());
        return articlesResponseDto;

    }

    @Override
    public ArticlesResponseDto getOne(Long id) {
        Optional<Articles> articles = articlesRepository.findById(id);

        if (!articles.isPresent()) {
            throw new IllegalArgumentException("이 글은 없습니다.");
        }
        return new ArticlesResponseDto(
                articles.get().getId(),
                articles.get().getTitle(),
                articles.get().getContent()
        );
    }

    @Override
    public List<ArticlesResponseDto> articlesRead() {
        return articlesRepository.findAll().stream()
                .map(articles -> new ArticlesResponseDto(
                        articles.getId(),
                        articles.getTitle(),
                        articles.getContent()))
                .collect(Collectors.toList());
    }


    @Override
    public ArticlesResponseDto articlesUpdate(Long id, ArticlesRequestDto articlesRequestDto) {
        Articles articles = articlesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지않습니다."));

        if (articlesRequestDto.getContent() == null || articlesRequestDto.getTitle() == null) {
            throw new IllegalArgumentException("제목과 내용은 비어있을수없습니다.");
        }
        articles.setTitle(articlesRequestDto.getTitle());
        articles.setContent(articlesRequestDto.getContent());

        Articles updateAtricles = articlesRepository.save(articles);
        return new ArticlesResponseDto(
                updateAtricles.getId(),
                updateAtricles.getTitle(),
                updateAtricles.getContent()
        );

    }

    @Override
    public void articlesDelete(Long id) {
        Articles articles = articlesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다."));
        articlesRepository.delete(articles);
    }
}

