package com.kunal.streaming_platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kunal.streaming_platform.service.StorageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class UploadController
{
    private final StorageService storageService;

    @PostMapping("/upload")
    public ResponseEntity<String> Upload(@RequestParam("file") MultipartFile file) throws Exception
    {
        try {
            storageService.uploadFile(file);
            return ResponseEntity.ok("Uploaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}