package co.istad.thymeleaf_webapp.thymeleaf.webapp.service;

import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.Article;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.Author;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {
    //find all article
    //POJO
    List<Article> finAll();
    boolean save(Article article, MultipartFile file);
    List<Article> getArticleByAuthor(Author author);
}
