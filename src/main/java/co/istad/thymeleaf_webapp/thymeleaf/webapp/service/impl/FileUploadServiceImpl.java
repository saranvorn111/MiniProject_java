package co.istad.thymeleaf_webapp.thymeleaf.webapp.service.impl;

import co.istad.thymeleaf_webapp.thymeleaf.webapp.model.FileUpload;
import co.istad.thymeleaf_webapp.thymeleaf.webapp.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Value("${file.server-path}")
    private String fileServerPath;
    @Override
    public FileUpload uploadSingle(MultipartFile file) {
        int dotLastIndex = file.getOriginalFilename().lastIndexOf(".");
        String ext = file.getOriginalFilename().substring(dotLastIndex+1);
        System.out.println(ext);
        String uuid=UUID.randomUUID().toString();
        String newFileNew = String.format("%s%s%s",uuid,".",ext);
        System.out.println(newFileNew);
//        1. create file path object
        Path paths = Paths.get(fileServerPath + newFileNew);
//        2.Copy file width path object
        try {
            Files.copy(file.getInputStream(),paths);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new FileUpload(newFileNew,true);

    }
}
