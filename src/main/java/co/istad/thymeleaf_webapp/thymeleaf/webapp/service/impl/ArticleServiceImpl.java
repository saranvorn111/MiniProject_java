package co.istad.thymeleaf_webapp.thymeleaf.webapp.service.impl;

import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.Article;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.Author;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.FileUpload;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.repository.ArticleRepository;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.repository.StaticRepository;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final StaticRepository staticRepository;

//    return articleRepository.select();

    private final FileUploadServiceImpl fileUploadService;
    private final ArticleRepository articleRepository;

    @Override
    public List<Article> finAll() {
        return articleRepository.select();
    }

    @Override
    public boolean save(Article article,MultipartFile file) {
        FileUpload fileUpload =fileUploadService.uploadSingle(file);
        if(fileUpload.isSucceed()){
            article.setUuid(UUID.randomUUID());
            article.setThumbnail(fileUpload.fileName());
//            staticRepository.getArticles().add(0,article);
            articleRepository.insert(article);
        }
        return true;
    }

    @Override
    public List<Article> getArticleByAuthor(Author author) {
        return null;
    }
}
