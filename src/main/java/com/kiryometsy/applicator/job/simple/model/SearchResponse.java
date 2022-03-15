package com.kiryometsy.applicator.job.simple.model;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class SearchResponse {
    private List<Results> postings;

    @Data
    @Builder
    public class Results {
        private String id;
        private String name;
    }
}
