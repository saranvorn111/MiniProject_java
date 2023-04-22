package co.istad.thymeleaf_webapp.thymeleaf.webapp.service;

import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();
    Author getAuthorById(Integer id);
}
