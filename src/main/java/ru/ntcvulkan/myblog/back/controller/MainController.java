package ru.ntcvulkan.myblog.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ntcvulkan.myblog.back.repository.ArticlesRepository;
import ru.ntcvulkan.myblog.back.entity.Article;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @Autowired
    ArticlesRepository articlesRepository;

//    @RequestMapping(
//            value = "/find",
//            method = RequestMethod.POST,
//            produces = "application/json"
//    )
//    public List<Article> findAllEntity() {
//        return articlesRepository.findAllDescDate();
//    }

    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<List<Article>> addEntity(@RequestBody Article articleHTTP) {
        List<Article> list = new ArrayList<>();
        articleHTTP.setDate(LocalDateTime.now());
        articlesRepository.save(articleHTTP);
        articlesRepository.findAll().forEach(p -> list.add(p));
        return ResponseEntity
                .ok()
                .body(list
                        .stream()
                        .sorted(Comparator
                                .comparing(Article::getDate)
                                .reversed())
                        .collect(Collectors.toList())
                );
    }

    @RequestMapping(
            value = "/find",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<List<Article>> findAllEntity() {
        List<Article> list = new ArrayList<>();
        articlesRepository.findAll().forEach(p -> list.add(p));
        return ResponseEntity
                .ok()
                .body(list
                        .stream()
                        .sorted(Comparator
                                .comparing(Article::getDate)
                                .reversed())
                        .collect(Collectors.toList())
                );
    }

}
