package com.kiryometsy.applicator.job.simple.controllers;

import com.kiryometsy.applicator.job.simple.dto.CriteriaSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/best-offers")
public class BestOffersController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${host.name}")
    private  String hostName;
    @Value("${host.endpoint}")
    private String endPoint;


    @GetMapping
    public List<CriteriaSearch> namedParams(@RequestParam(value="page", required = false) String page) {
        webClientBuilder.build()
                .get()
                .uri(hostName + endPoint + "backend?criteria=seniority%3Dtrainee,junior%20requirement%3Djava&page=1")
                .retrieve();
        return Arrays.asList(
                new CriteriaSearch("requierement");
        );

    }
}

