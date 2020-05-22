package org.xml.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


    public class JsonSimpleRead
    {
        @SuppressWarnings("unchecked")
        public static void main(String[] args)
        {
            JSONParser parser = new JSONParser();
            try
            {
                Object obj = parser.parse(new FileReader("/home/user/file_001.json"));
                JSONObject jsonObject = (JSONObject) obj;
                String name = (String) jsonObject.get("name");
                System.out.println(name);

                long age = (Long) jsonObject.get("age");
                System.out.println(age);

                JSONArray msg = (JSONArray) jsonObject.get("messages");
                Iterator<String> iterator = msg.iterator();
                while (iterator.hasNext())
                {
                    System.out.println(iterator.next());
                }
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
    }