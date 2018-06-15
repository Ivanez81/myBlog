package ru.ntcvulkan.myblog.back.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.ntcvulkan.myblog.back.dao.ArticlesDAO;
import ru.ntcvulkan.myblog.back.entity.Articles;

import java.util.Date;

@Component
public class DataInit implements ApplicationRunner {

    private ArticlesDAO articlesDAO;
    private static final Date date = new Date();

    @Autowired
    public DataInit(ArticlesDAO articlesDAO) {
        this.articlesDAO = articlesDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = articlesDAO.count();

        if (count == 0) {
            Articles a1 = new Articles();
            a1.setTitle("Article_1");
            a1.setArticle("Article_1, Test");
            a1.setDate(date);

            Articles a2 = new Articles();
            a2.setTitle("Article_2");
            a2.setArticle("Article_2, Test");
            a2.setDate(date);

            articlesDAO.save(a1);
            articlesDAO.save(a2);
        }
    }
}
