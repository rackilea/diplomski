package com.test;

import java.util.HashMap;

public class Brand{
    private static HashMap<String,BrandName> map = new HashMap<String,BrandName>();
public enum BrandName {
    HERO("hero"),HONDA("honda"),UNKNOWN("default");

    private String value = null;

     private BrandName(String value){
         this.value = value;
         addToMap();
     }

     private void addToMap(){
         map.put(this.value, this);
     }

     @Override
     public String toString(){
         return this.value;
     }

     public static BrandName fromValue(String value){
         return map.get(value) != null ? map.get(value) : map.get("default");
     }
}
}