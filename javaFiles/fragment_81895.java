package com.aamir.stackoverflow;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONParserStackOverflow {
    public static void main(String[] args) {

        String request = "{\n" +
                "    \"forecast\": {\n" +
                "        \"txt_forecast\": {\n" +
                "            \"date\": \"8: 00AMMST\",\n" +
                "            \"forecastday\": [\n" +
                "                {\n" +
                "                    \"period\": 0,\n" +
                "                    \"icon\": \"partlycloudy\",\n" +
                "                    \"icon_url\": \"http: //icons-ak.wxug.com/i/c/k/partlycloudy.gif\",\n" +
                "                    \"title\": \"Thursday\",\n" +
                "                    \"fcttext\": \"Partlycloudy.Highof63F.Windslessthan5mph.\",\n" +
                "                    \"fcttext_metric\": \"Partlycloudy.Highof17C.Windslessthan5km/h.\",\n" +
                "                    \"pop\": \"0\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}";

        JsonElement weatherJSON = new JsonParser().parse(request);
        JsonObject weatherObj = weatherJSON.getAsJsonObject();
        JsonObject forecastObj = weatherObj.get("forecast").getAsJsonObject();
        JsonObject txt_forecast = forecastObj.get("txt_forecast").getAsJsonObject();

        JsonArray forecastDays = txt_forecast.getAsJsonArray("forecastday");


        for(JsonElement forecastDay : forecastDays) {
            System.out.println(forecastDay.getAsJsonObject().get("fcttext").toString());
        }
    }
}