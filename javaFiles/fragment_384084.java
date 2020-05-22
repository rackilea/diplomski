package com.example.java;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Example {

  /**
   * Returns null or the result of calling a method on a scala object from java
   */
  public String callScalaFromJava(){
    String result = null;

    try {
      Class<?> clazz = Class.forName("com.example.Foo$"); // Note the trailing '$'
      Method method = clazz.getDeclaredMethod("bar");
      Field field = clazz.getField("MODULE$");
      Object instance = field.get(null);
      Object obj = method.invoke(instance, new Object[] {});

      if (obj instanceof String) {
        result = (String) obj);
      }

    } catch (Exception ex) {
      // SWALLOWING
    }
    return result;
  }
}