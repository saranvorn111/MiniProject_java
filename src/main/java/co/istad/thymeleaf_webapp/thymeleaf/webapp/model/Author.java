package co.istad.thymeleaf_webapp.thymeleaf.webapp.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @NotBlank
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String username;
    @NotBlank
    private String gender;
    @NotBlank
    private String email;
    @NotBlank
    private String address;
    @NotBlank
    private String avatar;
    @NotBlank
    private String cover;
    private List<Article> articles;

}
