package com.kiryometsy.applicator.job.simple.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/best-offers")
public class BestOffersController {

    @GetMapping
    public String namedParams
            (@RequestParam(name = "id") String dataId) {

        return "dataId: " + dataId;
    }


}
