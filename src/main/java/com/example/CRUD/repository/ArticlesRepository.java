package com.example.CRUD.repository;

import com.example.CRUD.entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Long> {
}

