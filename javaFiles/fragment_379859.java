package com.sof.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "iteration", "project", "isd", "ied"})
public class Details {

    @JsonProperty
    private String iteration;

    @JsonProperty
    private String project;

    @JsonProperty
    private String isd;

    @JsonProperty
    private String ied;

    public Details(String iteration, String project, String isd, String ied) {
        this.iteration = iteration;
        this.project = project;
        this.isd = isd;
        this.ied = ied;
    }

}