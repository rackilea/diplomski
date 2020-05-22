package jsontoxml;

import java.io.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import java.util.*;


public class JacksonStreamExample {

   public static void main(String[] args) {
       JSONParser parser = new JSONParser();
     try {
        Object obj = parser.parse(new FileReader("text.json"));
        JSONObject jsonObject = (JSONObject) obj;

        JSONArray cells = (JSONArray) jsonObject.get("cells");
        Iterator<JSONObject> iterator = cells.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

     } catch (Exception e) {

      e.printStackTrace();

     }

  }

}