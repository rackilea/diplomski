package com.so;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Sample {
    private Map<String,Foo> mapObject = new HashMap<String,Foo>();

    public Sample(){
        Foo foo = new Foo();
        mapObject.put("key", foo);
    }

    public void callMethods() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Method[] methods = mapObject.get("key").getClass().getDeclaredMethods();
        Object objectString = new String();
        objectString = "Hello";
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("printThisString")){
                method.invoke(mapObject.get("key"), objectString)   ;
            }

         }

    }

    public static void main(String...args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Sample sample = new Sample();
        sample.callMethods();
    }

}

class Foo {
    public void printThisString(String param){
        System.out.println(param);
    }
}