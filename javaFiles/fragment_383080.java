package com.stackoverflow.examplepackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class AnyClass {
  public static void main(String[] args) {
    testhello();
    System.out.println();
    breakhello();
  }

  public static void testhello(){
    System.out.print("Inside AnyClass - calling Main: ");
    Main test = new Main();
    test.hello();
  }

  public static void breakhello(){
    try {
      // Not necessary - same package, but..
      Class<?> mainClass = Class.forName("com.stackoverflow.examplepackage.Main");
      Constructor<?> constructor = mainClass.getConstructor();
      Object main = constructor.newInstance();

      // Getting, printing and changing the field..
      Field field = mainClass.getDeclaredField("privateString");
      field.setAccessible(true);
      System.out.println("  field.get() = " + field.get(main));
      field.set(main,"I'm not private anymore");
      System.out.println("  field.get() = " + field.get(main));

    } catch (Exception e) {  // Sorry, all in one big bucket
       System.out.println("Error: " + e);
    }
  }
}