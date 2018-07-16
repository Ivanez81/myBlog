package ru.ntcvulkan.myblog.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ntcvulkan.myblog.back.dao.ArticlesDAO;
import ru.ntcvulkan.myblog.back.entity.Articles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @Autowired
    private ArticlesDAO articlesDAO;

    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<List<Articles>> addEntity(@RequestBody Articles articlesHTTP) {
        List<Articles> list = new ArrayList<>();
        articlesHTTP.setDate(LocalDateTime.now());
        articlesDAO.save(articlesHTTP);
        articlesDAO.findAll().forEach(p -> list.add(p));
        return ResponseEntity
                .ok()
                .body(list
                        .stream()
                        .sorted(Comparator
                                .comparing(Articles::getDate)
                                .reversed())
                        .collect(Collectors.toList())
                );
    }

    @RequestMapping(
            value = "/find",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<List<Articles>> findAllEntity() {
        List<Articles> list = new ArrayList<>();
        articlesDAO.findAll().forEach(p -> list.add(p));
        return ResponseEntity
                .ok()
                .body(list
                        .stream()
                        .sorted(Comparator
                                .comparing(Articles::getDate)
                                .reversed())
                        .collect(Collectors.toList())
                );
    }
}
