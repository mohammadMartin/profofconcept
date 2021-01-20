package com.parseh.core.proofofconcept.peresentation;

import com.parseh.core.proofofconcept.application.ChannelService;
import com.parseh.core.proofofconcept.application.dto.ChannelResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/channel")
public class ChannelController {

    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping(value = "{page}/{size}")
    public List<ChannelResponseDTO> allUserChannels(@PathVariable Integer page, @PathVariable Integer size) {

        page = page == null ? 1 : page;
        size = size == null ? 10 : size;

        return channelService.allUserChannels(page, size);
    }
}
