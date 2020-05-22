package com.github.xsavikx.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class JacksonTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, DatabaseRow> data = new HashMap<>();
        DatabaseRow row = new DatabaseRow(2, "someData");
        data.put("1009558", row);
        String action = "action";
        DatabaseEntry dbEntry = new DatabaseEntry();
        dbEntry.setAction(action);
        dbEntry.setData(data);
        System.out.println(objectMapper.writeValueAsString(dbEntry));
    }
}