package com.kiryometsy.applicator.job.simple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class JobApplicatorController {

    @GetMapping
    public String helloGradle() {
        return "Hello Gradle!";
    }

}
