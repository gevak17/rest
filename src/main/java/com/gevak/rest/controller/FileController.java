package com.gevak.rest.controller;

import com.gevak.rest.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    private FileService fileService;

    public FileController(@Autowired FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/upload-file")
    public void index(@RequestParam(value = "file") MultipartFile file) {
        fileService.processCsvFile(file);
    }

}
