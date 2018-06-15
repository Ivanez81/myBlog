package ru.ntcvulkan.myblog.back.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ntcvulkan.myblog.back.entity.Articles;

@Repository
public interface ArticlesDAO extends CrudRepository<Articles, Long> {
}
