package ru.ntcvulkan.myblog.back.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.ntcvulkan.myblog.back.dao.ArticlesDAO;
import ru.ntcvulkan.myblog.back.entity.Articles;

import java.time.LocalDateTime;

@Component
public class DataInit implements ApplicationRunner {

    private ArticlesDAO articlesDAO;

    @Autowired
    public DataInit(ArticlesDAO articlesDAO) {
        this.articlesDAO = articlesDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = articlesDAO.count();

        if (count == 0) {
            Articles a1 = new Articles();
            a1.setTitle("Lorem ipsum.");
            a1.setArticle("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quam commodi sint, at maxime," +
                    " voluptatem autem, numquam incidunt doloremque unde, rem odit alias aperiam voluptas velit ut." +
                    " Veniam impedit eveniet dolores!");
            a1.setDate(LocalDateTime.now().minusMinutes(3));

            Articles a2 = new Articles();
            a2.setTitle("Suscipit, nisi.");
            a2.setArticle("Esse aut placeat aliquam fuga eveniet nisi, ullam praesentium officiis mollitia quisquam," +
                    " sint ipsam quibusdam quasi. Voluptas doloremque exercitationem sit nisi. Fugiat aperiam dolore," +
                    " quidem possimus doloremque libero dolorum ex?");
            a2.setDate(LocalDateTime.now().minusMinutes(2));

            Articles a3 = new Articles();
            a3.setTitle("Quisquam, unde.");
            a3.setArticle("Suscipit omnis eum cupiditate vel ipsa voluptate aut similique distinctio! Incidunt" +
                    " quaerat facilis, quibusdam unde placeat at corrupti illum assumenda consequuntur, quam ab," +
                    " officia rem provident tenetur labore sequi nesciunt!");
            a3.setDate(LocalDateTime.now().minusMinutes(1));

            Articles a4 = new Articles();
            a4.setTitle("Consequatur, tenetur!");
            a4.setArticle("Provident distinctio nostrum nihil, fugit atque illum nisi tempora doloremque," +
                    " voluptatibus, adipisci eveniet eos, odit accusantium a sit laudantium aliquid cupiditate!" +
                    " Quam laboriosam dolor doloribus rerum ipsum velit iste architecto!");
            a4.setDate(LocalDateTime.now());

            articlesDAO.save(a1);
            articlesDAO.save(a2);
            articlesDAO.save(a3);
            articlesDAO.save(a4);
        }
    }
}
