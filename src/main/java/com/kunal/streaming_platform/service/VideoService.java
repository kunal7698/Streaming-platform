package com.kunal.streaming_platform.service;

import com.kunal.streaming_platform.dto.VideoUploadResponse;
import org.springframework.web.multipart.MultipartFile;

public interface VideoService {

    VideoUploadResponse uploadVideo(MultipartFile file) throws Exception;

}
