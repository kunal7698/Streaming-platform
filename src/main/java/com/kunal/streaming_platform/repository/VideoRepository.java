package com.kunal.streaming_platform.repository;

import com.kunal.streaming_platform.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}