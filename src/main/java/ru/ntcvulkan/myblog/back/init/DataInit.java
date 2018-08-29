package ru.ntcvulkan.myblog.back.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.ntcvulkan.myblog.back.repository.ArticlesRepository;
import ru.ntcvulkan.myblog.back.entity.Article;

import java.time.LocalDateTime;

@Component
public class DataInit implements ApplicationRunner {

    private ArticlesRepository articlesRepository;

    @Autowired
    public DataInit(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = articlesRepository.count();

        if (count == 0) {
            Article a1 = new Article();
            a1.setTitle("Lorem ipsum.");
            a1.setArticle("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quam commodi sint, at maxime," +
                    " voluptatem autem, numquam incidunt doloremque unde, rem odit alias aperiam voluptas velit ut." +
                    " Veniam impedit eveniet dolores!");
            a1.setDate(LocalDateTime.now().minusMinutes(3));

            Article a2 = new Article();
            a2.setTitle("Suscipit, nisi.");
            a2.setArticle("Esse aut placeat aliquam fuga eveniet nisi, ullam praesentium officiis mollitia quisquam," +
                    " sint ipsam quibusdam quasi. Voluptas doloremque exercitationem sit nisi. Fugiat aperiam dolore," +
                    " quidem possimus doloremque libero dolorum ex?");
            a2.setDate(LocalDateTime.now().minusMinutes(2));

            Article a3 = new Article();
            a3.setTitle("Quisquam, unde.");
            a3.setArticle("Suscipit omnis eum cupiditate vel ipsa voluptate aut similique distinctio! Incidunt" +
                    " quaerat facilis, quibusdam unde placeat at corrupti illum assumenda consequuntur, quam ab," +
                    " officia rem provident tenetur labore sequi nesciunt!");
            a3.setDate(LocalDateTime.now().minusMinutes(1));

            Article a4 = new Article();
            a4.setTitle("Consequatur, tenetur!");
            a4.setArticle("Provident distinctio nostrum nihil, fugit atque illum nisi tempora doloremque," +
                    " voluptatibus, adipisci eveniet eos, odit accusantium a sit laudantium aliquid cupiditate!" +
                    " Quam laboriosam dolor doloribus rerum ipsum velit iste architecto!");
            a4.setDate(LocalDateTime.now());

            articlesRepository.save(a1);
            articlesRepository.save(a2);
            articlesRepository.save(a3);
            articlesRepository.save(a4);
        }
    }
}
