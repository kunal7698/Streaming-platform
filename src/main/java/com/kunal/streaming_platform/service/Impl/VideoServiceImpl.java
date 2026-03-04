package com.kunal.streaming_platform.service.Impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kunal.streaming_platform.dto.VideoUploadResponse;
import com.kunal.streaming_platform.entity.Video;
import com.kunal.streaming_platform.repository.VideoRepository;
import com.kunal.streaming_platform.service.StorageService;
import com.kunal.streaming_platform.service.VideoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService{
    
    private final StorageService storageService;
    private final VideoRepository videoRepository;

    @Override
    public VideoUploadResponse uploadVideo(MultipartFile file) throws Exception
    {
        String objectKey = storageService.uploadFile(file);

        Video video = Video.builder()
                .fileName(file.getOriginalFilename())
                .objectKey(objectKey)
                .size(file.getSize())
                .contentType(file.getContentType())
                .uploadedAt(LocalDateTime.now())
                .build();

        video = videoRepository.save(video);

        return new VideoUploadResponse(video.getId(), video.getFileName());
    }
}
