package com.kunal.streaming_platform.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StorageService {
    private final MinioClient minioClient;

    @Value("${minio.bucket}")
    private String bucket;

    public void uploadFile(MultipartFile file) throws Exception
    {
        minioClient.putObject(
            PutObjectArgs.builder()
            .bucket(bucket)
            .object(file.getOriginalFilename())
            .stream(file.getInputStream(), file.getSize(), -1)
            .contentType(file.getContentType())
            .build()
        );
    }
}
