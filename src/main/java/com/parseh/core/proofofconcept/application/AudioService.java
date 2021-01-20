package com.parseh.core.proofofconcept.application;

import com.parseh.core.proofofconcept.application.dto.AudioResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class AudioService {
    private final RestTemplate restTemplate;

    public AudioService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${api.url.audio}")
    private String AUDIO_URL;

    @Value("${api.key}")
    private String API_KEY;

    public List<AudioResponseDTO> allAudio(String page, String size) {
        String channel = "";

        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("filter", "");
        request.add("page", page);
        request.add("per_page", size);
        request.add("secure_ip","");
        request.add("secure_expire_time","");

        ResponseEntity<List<AudioResponseDTO>> response = restTemplate.exchange(
                AUDIO_URL + channel + "/audios",
                HttpMethod.GET,
                new HttpEntity<>(request, requestHeaders()),
                new ParameterizedTypeReference<List<AudioResponseDTO>>() {
                }
        );

        if (response == null || response.getBody() == null)
            throw new RuntimeException("fetch unSuccessFull");

        return response.getBody();
    }

    private HttpHeaders requestHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.add("Authorization", "ApiKey " + API_KEY);
        return requestHeaders;
    }

}
