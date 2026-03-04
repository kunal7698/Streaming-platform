package com.kunal.streaming_platform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VideoUploadResponse {

    private Long id;
    private String fileName;

}