package com.parseh.core.proofofconcept.application;

import com.parseh.core.proofofconcept.application.dto.ChannelResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ChannelService {

    private final RestTemplate restTemplate;

    public ChannelService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${api.url.channel}")
    private String CHANNEL_URL;

    @Value("${api.key}")
    private String API_KEY;

    public List<ChannelResponseDTO> allUserChannels(Integer page, Integer size) {

        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("filter", "");
        request.add("page", page.toString());
        request.add("per_page", size.toString());

        ResponseEntity<Map> response = restTemplate.exchange(
                CHANNEL_URL,
                HttpMethod.GET,
                new HttpEntity<>(request, requestHeaders()),
                new ParameterizedTypeReference<Map>() {
                }
        );

        if (response == null || response.getBody() == null)
            throw new RuntimeException("fetch unSuccessFull");

//        return response.getBody();
        return new ArrayList<>();
    }


    private HttpHeaders requestHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.add("Authorization", "ApiKey " + API_KEY);
        return requestHeaders;
    }


}
