package inetum.feign.usermc.controller;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@RestController
public class ImageController {
    private final String IMAGE_DIR = "C:/xampp/htdocs/img/";

    // Gérer l'upload de fichiers
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException, FileUploadException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Le fichier ne peut pas être vide.");
        }
        String fileName = file.getOriginalFilename();
        File dest = new File(IMAGE_DIR + fileName);
        file.transferTo(dest);
        return ResponseEntity.ok().body("Le fichier a été téléversé avec succès.");
    }


    // Gérer le download de fichiers
//    @PostMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    public ResponseEntity<Resource> downloadFile(@RequestParam("fileName") String fileName) throws IOException {
//        File file = new File(IMAGE_DIR + fileName);
//        Resource resource = new UrlResource(file.toURI());
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }
    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadFile(@RequestParam("fileName") String fileName) throws IOException {
        File file = new File(IMAGE_DIR + fileName);
        Resource resource = new UrlResource(file.toURI());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}