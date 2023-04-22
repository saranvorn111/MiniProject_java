package co.istad.thymeleaf_webapp.thymeleaf.webapp.repository;

import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleRepository {
    @Insert("""
            INSERT INTO articles (uuid,title,thumbnail,author)
            VALUES (#{a.uuid},#{a.title},#{a.thumbnail},#{a.author})
            """)
    void insert(@Param("a") Article article);
    @Select("SELECT * FROM articles ORDER BY title DESC")
    List<Article> select();

    @Select("SELECT * FROM articles WHERE uuid =#{uuid}")
    Article selectByUuid(String uuid);

}
