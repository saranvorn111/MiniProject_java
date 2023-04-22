package co.istad.thymeleaf_webapp.thymeleaf.webapp.controller;

import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.Article;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.service.ArticleService;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.service.FileUploadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

//    private final FileUploadService fileUploadService;

    @GetMapping
    String viewArticle(Model model){
        List<Article> articles=articleService.finAll();
        model.addAttribute("articles",articles);
        return "pages/article/article";
    }
    @GetMapping("/new")
    String viewArticleNew(Article article,Model model ){
        model.addAttribute("article",article);
        return "pages/article/article-new";
    }

    @PostMapping("/new")
    String doSaveArticle(@ModelAttribute @Valid Article article,
                         BindingResult result,
                         @RequestParam("thumbnailFile") MultipartFile file,
                         Model model){
        if(result.hasErrors()){
            model.addAttribute("article",article);
           return "pages/article/article-new";
        }
//        fileUploadService.uploadSingle(file);
        boolean isSucceed= articleService.save(article, file);
        if(isSucceed){
            return "redirect:/article/new";
        }
        return "pages/article/article-new";

    }

}
