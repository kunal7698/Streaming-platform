package com.kunal.streaming_platform.service;

import org.springframework.web.multipart.MultipartFile;
public interface StorageService {

    String uploadFile(MultipartFile file) throws Exception;
}


