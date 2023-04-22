package co.istad.thymeleaf_webapp.thymeleaf.webapp.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private UUID uuid;
    @NotBlank(message = "Title is required...")
    private String title;

    private String thumbnail;
    private List<Category> categories;
    @NotBlank(message = "Author is required...")
    private String author;


}
