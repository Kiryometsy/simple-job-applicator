package com.kiryometsy.applicator.job.simple.controllers;

import com.kiryometsy.applicator.job.simple.model.CriteriaSearch;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

import static com.kiryometsy.applicator.job.simple.model.CriteriaSearch.defaultCriteriaSearch;

@RestController
@RequestMapping("/best-offers")
public class BestOffersController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${host.name}")
    private  String hostName;
    @Value("${host.endpoint}")
    private String endPoint;

    @SneakyThrows
    @GetMapping
    public String namedParams(@RequestParam(value="page", required = false) String page) {
        WebClient client = WebClient.create();

        String response = client.post()
                .uri(new URI(hostName + endPoint))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .body(defaultCriteriaSearch(), CriteriaSearch.class)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
    }
}

