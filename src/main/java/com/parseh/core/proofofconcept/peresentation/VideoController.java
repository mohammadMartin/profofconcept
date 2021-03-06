package com.parseh.core.proofofconcept.peresentation;

import com.parseh.core.proofofconcept.application.AudioService;
import com.parseh.core.proofofconcept.application.VideoService;
import com.parseh.core.proofofconcept.application.dto.AudioResponseDTO;
import com.parseh.core.proofofconcept.application.dto.VideoResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/video")
public class VideoController {
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping(value = "{page}/{size}")
    public List<VideoResponseDTO> allAudio(@PathVariable String page, @PathVariable String size) {
        return videoService.allVideo(page, size);
    }
}

