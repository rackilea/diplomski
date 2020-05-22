package com.stackoverflow.answer;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParserExample {

    public static void main(String[] args) {
        String message = "{ \"animal\" : [{\"name\":\"alice\", \"type\":\"cat\"}, {\"name\":\"john\", \"type\":\"dog\"}, {\"name\":\"peter\", \"type\":\"bird\"} ] }";
        JSONObject messageJson = new JSONObject(message);
        JSONArray animals = messageJson.getJSONArray("animal");

        int n = animals.length();
        for (int i = 0; i < n; ++i) {
            JSONObject animal = animals.getJSONObject(i);
            System.out.println(String.format("animal.%d.name: %s", i, animal.getString("name")));
            System.out.println(String.format("animal.%d.type: %s", i, animal.getString("type")));
        }
    }

}