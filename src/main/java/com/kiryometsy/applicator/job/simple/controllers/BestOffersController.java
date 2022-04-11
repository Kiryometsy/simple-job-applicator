package com.kiryometsy.applicator.job.simple.controllers;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

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
                .uri(hostName + endPoint)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("{\n" +
                        "    \"criteriaSearch\": {\n" +
                        "        \"requirement\": [\n" +
                        "            \"java\"\n" +
                        "        ],\n" +
                        "        \"category\": [\n" +
                        "            \"backend\"\n" +
                        "        ],\n" +
                        "        \"city\": [\n" +
                        "            \"kraków\"\n" +
                        "        ],\n" +
                        "        \"salary\": [],\n" +
                        "        \"employment\": [],\n" +
                        "        \"seniority\": [\n" +
                        "            \"trainee\",\n" +
                        "            \"junior\"\n" +
                        "        ],\n" +
                        "        \"more\": [],\n" +
                        "        \"keyword\": [],\n" +
                        "        \"company\": []\n" +
                        "    }\n" +
                        "}"))
                //.body(defaultCriteriaSearch(), CriteriaSearch.class)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
    }
}

