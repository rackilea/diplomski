package com.dd;

import java.lang.reflect.InvocationTargetException;

public class Z {

    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            NoSuchMethodException, SecurityException, IllegalArgumentException,
            InvocationTargetException {

        CustomClassLoader loader = new CustomClassLoader();
        Class<?> c1 = loader.findClass("com.dd.X");

        System.out.println("Classloader:: "+ X.class.getClassLoader());
        System.out.println("Classloader:: "+ loader.findClass("com.dd.X").getClassLoader());

        X x = (X)c1.newInstance();
    }
}