package com.kiryometsy.applicator.job.simple.model;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class CriteriaSearch {
    private List<String> requirement;
    private List<String> category;
    private List<String> city;
    private List<Object> salary;
    private List<Object> employment;
    private List<String> seniority;
    private List<Object> more;
    private List<Object> keyword;
    private List<Object> company;

    public static CriteriaSearch defaultCriteriaSearch() {
        return CriteriaSearch
                .builder()
                .city(List.of("krakow"))
                .build();
    }
}