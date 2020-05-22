package com.pragin.ocjp;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonExample {

public String jsonEx(){
    String url = "  https://api.tfl.gov.uk/Place?lat=51.555504&lon=0.0592359&radius=80&includeChildren=False&type=NaptanPublicBusCoachTram&app_id=95a7b158&app_key=a3acd48055f470cf35ab5f6f360604c5";
    URL obj;
    BufferedReader reader;
    StringBuilder stringBuilder;
    HttpURLConnection con;
    stringBuilder = new StringBuilder();
    try {
        obj = new URL(url);
         con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode(); // to check success and failure of API call

        System.out.println("Response Code : " + responseCode);
        String response = con.getResponseMessage();

        System.out.println("Response : " + response.toString());

        reader = new BufferedReader(new InputStreamReader(con.getInputStream()));


        String line = null;

        while ((line = reader.readLine()) != null){
            stringBuilder.append(line + "\n");

            System.out.println("String : " + stringBuilder.toString());
        }
        //return stringBuilder.toString();

    }catch(IOException e){
        System.out.println("Error" + e);
    }
    return stringBuilder.toString();

}

public void jsonParser(String res) throws ParseException {
    JSONParser jParse = new JSONParser();

    JSONObject jsonObject = (JSONObject) jParse.parse(res);
    System.out.println("res = [" + jsonObject.size() + "]");
    for(int i = 0; i <jsonObject.size(); i++ ){
       // JSONObject jsonObject = (JSONObject) jArray.get(i);
       // jsonObject.
        String name = (String) jsonObject.get("$type");
        System.out.println("Name : " + name);
    }

}

public static void main(String[] args) throws ParseException {
    JsonExample js = new JsonExample();
    js.jsonParser(js.jsonEx());
}