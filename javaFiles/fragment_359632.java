package de.pandaadb.jackson;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataModel {

    private String test;
    private String optionalValue;

    @JsonCreator
    public DataModel(@JsonProperty("test") String test, @JacksonInject("opt") @JsonProperty(value= "opt", required=false)String opt) {
        this.optionalValue = opt;
        this.test = test;
    }

    @Override
    public String toString() {
        return "test=" + test + " optional=" + optionalValue;
    }


    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        InjectableValues.Std std = new InjectableValues.Std();
        std.addValue("opt", "alternative");

        String withOptional = "{\"test\" : \"hello\" ,    \"opt\" : \"optss\"}";
        String withoutOptional = "{\"test\" : \"hello\"}";

        mapper.setInjectableValues(std);

        System.out.println(mapper.readValue(withOptional, DataModel.class));
        System.out.println(mapper.readValue(withoutOptional, DataModel.class));
    }
}