package com.testing;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapExp {

    public static void main(String[] args) 
    { 
        NavigableMap<Float, Float> nm = 
                          new TreeMap<>(); 
        nm.put(84.27f, -4f); 
        nm.put(84.31f, -3.99f); 
        nm.put(84.35f, 3.98f); 
        nm.put(84.39f, -3.97f); 

        System.out.printf("value  : %s%n", nm.floorEntry(84.33f)); 
    } 

}