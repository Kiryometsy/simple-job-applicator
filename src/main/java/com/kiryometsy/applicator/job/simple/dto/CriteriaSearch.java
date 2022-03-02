package com.kiryometsy.applicator.job.simple.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public @Data class CriteriaSearch {
    private List<String> requirement = new ArrayList<String>();
    private List<String> category = new ArrayList<String>();
    private List<String> city = new ArrayList<String>();
    private List<Object> salary = new ArrayList<Object>();
    private List<Object> employment = new ArrayList<Object>();
    private List<String> seniority = new ArrayList<String>();
    private List<Object> more = new ArrayList<Object>();
    private List<Object> keyword = new ArrayList<Object>();
    private List<Object> company = new ArrayList<Object>();
}
