package com.zack.demo;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class GsonTest {

    public static void main(String[] args) {

        Gson gson = new Gson();

        Map<String, Object> resultMap = new HashMap<String, Object>();

        Employee o1 = new Employee("Test1", 10, "Male");

        resultMap.put("T1", o1);

        Employee o2 = new Employee("Test2", 20, "Male");

        resultMap.put("T2", o2);

        String result = gson.toJson(resultMap, resultMap.getClass());

        System.out.println(result);

        Map<String, Object> resultOutputMap = new HashMap<String, Object>();

        resultOutputMap = (Map<String, Object>) gson.fromJson(result,
                resultOutputMap.getClass());

        System.out.println("Complete Map: "+ resultOutputMap.toString());

        System.out.println("Values: "+resultOutputMap.values().toString());

        System.out.println("Keys: "+resultOutputMap.keySet().toString());

    }

}