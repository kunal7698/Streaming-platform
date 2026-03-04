package com.kunal.streaming_platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final MinioClient minioClient;

    @GetMapping("/test-minio")
    public String test() {
        return "MinIO client injected successfully";
    }
}
