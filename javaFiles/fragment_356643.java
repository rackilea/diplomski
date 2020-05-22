package com.stackoverflow.answer;

import org.json.JSONObject;

public class JsonTest {

    public static void main(String[] args) {
        String response = "{ \"message\": \"The request is invalid.\", \"modelState\": { \"\": [ \"Passwords must be at least 6 characters.\"]}}";
        JSONObject jsonObject = new JSONObject(response);
        String errorMessage = jsonObject.getJSONObject("modelState").getJSONArray("").getString(0);
        System.out.println(errorMessage);
    }

}