package com.so;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParsing {

    /**
     * @param args
     * @throws JSONException 
     */
    public static void main(String[] args) throws JSONException {

        String retrievedJson= "{\"datestamp\":\"2016-11-22T20:46:38Z\",\"interval\":209836}";
        JSONObject jsonTime = new JSONObject(retrievedJson);
        Long interval = jsonTime.getLong("interval");
        System.out.println("Main Json Data : " + interval);

        String retrievedJson2 = "{\"datestamp\":\"2016-11-22T20:46:38Z\",\"interval\":209836,inner:{\"datestamp\":\"2016-11-22T20:46:38Z\",\"interval\":209837}}";
        JSONObject jsonTime2 = new JSONObject(retrievedJson2);
        String interval2 = jsonTime2.getJSONObject("inner").getString("interval");
        System.out.println("Inner Json Data : "+ interval2);
        //String interval1 = jsonTime. //<--- and if I do it this way it get the JSONException: JSONObject not found exception


    }

}