package ru.ntcvulkan.myblog.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ntcvulkan.myblog.back.entity.Article;

import java.util.List;

@Repository
public interface ArticlesRepository extends JpaRepository<Article, Long> {

//    @Query("SELECT b FROM blog b ORDER BY b.date DESC")
//    List<Article> findAllDescDate();
}
