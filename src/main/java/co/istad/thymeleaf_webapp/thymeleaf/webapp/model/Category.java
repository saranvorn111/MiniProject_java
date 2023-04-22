package co.istad.thymeleaf_webapp.thymeleaf.webapp.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Category {
    @NotBlank
    private Integer id;
    @NotBlank
    private String name;
    private List<Article> articles;
}
