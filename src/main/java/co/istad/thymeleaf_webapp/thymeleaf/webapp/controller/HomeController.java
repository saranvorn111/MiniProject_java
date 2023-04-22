package co.istad.thymeleaf_webapp.thymeleaf.webapp.controller;

import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.Article;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ArticleService articleService;
   @GetMapping("/")
    String viewHome(Model model){
       List<Article> articles = articleService.finAll();
       model.addAttribute("articles",articles);
       return "pages/index";
   }
   @GetMapping("/post")
    String viewPost(){
       return "pages/post";
   }



 }
