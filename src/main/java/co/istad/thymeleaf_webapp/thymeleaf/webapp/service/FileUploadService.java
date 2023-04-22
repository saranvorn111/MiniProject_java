package co.istad.thymeleaf_webapp.thymeleaf.webapp.service;

import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.FileUpload;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    FileUpload uploadSingle(MultipartFile file);
}
