package com.github.xsavikx.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonTest {
    public static void main(String[] args) throws IOException {
        serializeTest();
        deserializeTest();
    }
    private static void deserializeTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        DatabaseEntry databaseEntry = objectMapper.readValue("{\"action\":\"action\",\"data\":{\"1009558\":{\"weekNumber\":2,\"someData\":\"someData\"}}}", DatabaseEntry.class);
        System.out.println(databaseEntry);
    }

    private static void serializeTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Map<String,String>> data = new HashMap<>();
        Map<String,String> values = new HashMap<>();
        values.put("weekDay","2");
        values.put("unpredictableValue","value");
        data.put("1009558", values);
        String action = "action";
        DatabaseEntry dbEntry = new DatabaseEntry();
        dbEntry.setAction(action);
        dbEntry.setData(data);
        System.out.println(objectMapper.writeValueAsString(dbEntry));
    }
}