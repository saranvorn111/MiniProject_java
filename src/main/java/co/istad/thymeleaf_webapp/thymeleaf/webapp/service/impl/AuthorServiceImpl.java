package co.istad.thymeleaf_webapp.thymeleaf.webapp.service.impl;

import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.Article;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.Author;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.repository.StaticRepository;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.service.ArticleService;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final StaticRepository staticRepository;

    @Override
    public List<Author> getAuthors() {
        return staticRepository.getAuthors();
    }

    @Override
    public Author getAuthorById(Integer id) {
        return staticRepository.getAuthors().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().orElse(null);
    }
}
