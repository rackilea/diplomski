package com.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Json {

    public static void main(String[] args) {
        printScore("test.json");
    }

    public static void printScore(String data) {
        JsonParser parser = new JsonParser();
        String link = data;
        JsonArray a;
        try {
            a = (JsonArray) parser.parse(new FileReader(link));
            for (Object o : a) {
                JsonObject jsonObject = (JsonObject) o;
                double score = jsonObject.get("sentiment").getAsDouble();
                System.out.format("%.3f", score);
            }
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}