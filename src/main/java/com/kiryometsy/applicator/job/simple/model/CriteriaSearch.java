/*
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
 */

package com.kiryometsy.applicator.job.simple.model;

import lombok.Data;

import java.util.List;

@Data
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

    CriteriaSearch(List<String> requirement, List<String> category, List<String> city, List<Object> salary, List<Object> employment, List<String> seniority, List<Object> more, List<Object> keyword, List<Object> company) {
        this.requirement = requirement;
        this.category = category;
        this.city = city;
        this.salary = salary;
        this.employment = employment;
        this.seniority = seniority;
        this.more = more;
        this.keyword = keyword;
        this.company = company;
    }

    public static CriteriaSearch defaultCriteriaSearch() {
        return CriteriaSearch
                .builder()
                .city(List.of("krakow"))
                .build();
    }

    public static CriteriaSearchBuilder builder() {
        return new CriteriaSearchBuilder();
    }

    public CriteriaSearchBuilder toBuilder() {
        return new CriteriaSearchBuilder().requirement(this.requirement).category(this.category).city(this.city).salary(this.salary).employment(this.employment).seniority(this.seniority).more(this.more).keyword(this.keyword).company(this.company);
    }

    public static class CriteriaSearchBuilder {
        private List<String> requirement;
        private List<String> category;
        private List<String> city;
        private List<Object> salary;
        private List<Object> employment;
        private List<String> seniority;
        private List<Object> more;
        private List<Object> keyword;
        private List<Object> company;

        CriteriaSearchBuilder() {
        }

        public CriteriaSearchBuilder requirement(List<String> requirement) {
            this.requirement = requirement;
            return this;
        }

        public CriteriaSearchBuilder category(List<String> category) {
            this.category = category;
            return this;
        }

        public CriteriaSearchBuilder city(List<String> city) {
            this.city = city;
            return this;
        }

        public CriteriaSearchBuilder salary(List<Object> salary) {
            this.salary = salary;
            return this;
        }

        public CriteriaSearchBuilder employment(List<Object> employment) {
            this.employment = employment;
            return this;
        }

        public CriteriaSearchBuilder seniority(List<String> seniority) {
            this.seniority = seniority;
            return this;
        }

        public CriteriaSearchBuilder more(List<Object> more) {
            this.more = more;
            return this;
        }

        public CriteriaSearchBuilder keyword(List<Object> keyword) {
            this.keyword = keyword;
            return this;
        }

        public CriteriaSearchBuilder company(List<Object> company) {
            this.company = company;
            return this;
        }

        public CriteriaSearch build() {
            return new CriteriaSearch(requirement, category, city, salary, employment, seniority, more, keyword, company);
        }

        public String toString() {
            return "CriteriaSearch.CriteriaSearchBuilder(requirement=" + this.requirement + ", category=" + this.category + ", city=" + this.city + ", salary=" + this.salary + ", employment=" + this.employment + ", seniority=" + this.seniority + ", more=" + this.more + ", keyword=" + this.keyword + ", company=" + this.company + ")";
        }
    }
}