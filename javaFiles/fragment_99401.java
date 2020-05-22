package com.abhi.learning.stackoverflow;

import java.util.List;

public class Example {

    private String value;
    private List<String> synonyms = null;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

}