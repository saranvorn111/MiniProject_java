package co.istad.thymeleaf_webapp.thymeleaf.webapp.controller;

import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.Article;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.Author;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.service.ArticleService;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final ArticleService articleService;
    private final AuthorService authorService;
//    @GetMapping("/author")
//    String viewAuthor(Model model){
//        List<Article> articles = articleService.finAll();
//        model.addAttribute("articles",articles);
//        return "pages/author";
//    }
//    @GetMapping("/profile")
//    String viewProfile(Model model){
//        List<Article> articles = articleService.finAll();
//        model.addAttribute("articles",articles);
//        return "pages/profile";
//    }
    @GetMapping
    String author(Model model){
        model.addAttribute("author",authorService.getAuthors());
        return "pages/author";
    }
    @GetMapping("/{id}")
    String authorProfile(@PathVariable Integer id,Model model){
        Author author = authorService.getAuthorById(id);
        List<Article> articles = articleService.getArticleByAuthor(author);
        author.setArticles(articles);
        model.addAttribute("author",author);
        return "pages/author-profile";
    }
}

