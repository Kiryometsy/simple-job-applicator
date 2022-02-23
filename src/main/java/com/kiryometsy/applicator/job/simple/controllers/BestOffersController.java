package com.kiryometsy.applicator.job.simple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/best-offers")
public class BestOffersController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${host.name}")
    private  String hostName;


    @GetMapping
    public String namedParams(@RequestParam(value="page", required = false) String page)
    {
        // backend?criteria=seniority%3Dtrainee,junior%20requirement%3Djava&page=1

        webClientBuilder.build()
                .get()
                .uri(hostName + "backend?criteria=seniority%3Dtrainee,junior%20requirement%3Djava&page=1")
                .retrieve();
        return hostName + "backend?criteria=seniority%3Dtrainee,junior%20requirement%3Djava&page=1";
    }
}

