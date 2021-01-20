package com.parseh.core.proofofconcept.peresentation;

import com.parseh.core.proofofconcept.application.AudioService;
import com.parseh.core.proofofconcept.application.dto.AudioResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/audio")
public class AudioController {
    private final AudioService audioService;

    public AudioController(AudioService audioService) {
        this.audioService = audioService;
    }
    @GetMapping(value = "{page}/{size}")
    public List<AudioResponseDTO> allAudio(@PathVariable String page, @PathVariable String size){
        return audioService.allAudio(page,size);
    }
}

