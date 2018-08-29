package ru.ntcvulkan.myblog.back.service;

import ru.ntcvulkan.myblog.back.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    Article addArticle(Article article);
    void delete(long id);
    Optional<Article> getById(long id);
    Article editArticle(Article article);
    List<Article> getAll();

}
