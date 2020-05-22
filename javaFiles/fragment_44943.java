package stackoverflow.questions;

import java.util.*;

import com.google.gson.Gson;

public class Q20433539{

   public static void main(String[] args){
         String json = "{\"results\":"+
         "[{\"_type\":\"Position\",\"_id\":377078,\"name\":\"Potsdam, Germany\",\"type\":\"location\",\"geo_position\":{\"latitude\":52.39886,\"longitude\":13.06566}},"+
         "{\"_type\":\"Position\",\"_id\":410978,\"name\":\"Potsdam, USA\",\"type\":\"location\",\"geo_position\":{\"latitude\":44.66978,\"longitude\":-74.98131}}]}";


   Gson gson = new Gson();
   Map m = gson.fromJson(json, Map.class);

   List<Map> innerList = (List<Map>) m.get("results");
   for(Map result: innerList){
      Map<String, Double> geo_position = (Map<String, Double>) result.get("geo_position");
      result.put("latitude", geo_position.get("latitude"));
      result.put("longitude", geo_position.get("longitude"));
      result.remove("geo_position");
   }
   System.out.println(gson.toJson(m));


   }


}