package ru.ntcvulkan.myblog.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.ntcvulkan.myblog.back.dao.ArticlesDAO;
import ru.ntcvulkan.myblog.back.entity.Articles;

@Controller
public class MainController {

    @Autowired
    private ArticlesDAO articlesDAO;

    @ResponseBody
    @RequestMapping
    public String index() {
        Iterable<Articles> all = articlesDAO.findAll();

        StringBuilder sb = new StringBuilder();

        all.forEach(p -> sb.append(p.getDate() + " | " + p.getTitle() + " | " + p.getArticle() + "<br>"));

        return sb.toString();
    }

}
