package ru.ntcvulkan.myblog.back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ntcvulkan.myblog.back.entity.Article;
import ru.ntcvulkan.myblog.back.repository.ArticlesRepository;
import ru.ntcvulkan.myblog.back.service.ArticleService;

import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticlesRepository articlesRepository;

    @Override
    public Article addArticle(Article article) {
        return articlesRepository.saveAndFlush(article);
    }

    @Override
    public void delete(long id) {
        articlesRepository.deleteById(id);
    }

    @Override
    public Optional<Article> getById(long id) {
        return articlesRepository.findById(id);
    }

    @Override
    public Article editArticle(Article article) {
        return articlesRepository.saveAndFlush(article);
    }

    @Override
    public List<Article> getAll() {
        return articlesRepository.findAll();
    }
}
