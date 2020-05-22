package com.company;

public class MyClass {
  public static void main(String[] args) {
    int longVariableName = publicStaticMethod();
    String abcxyz = privateStaticMethod("abc", "xyz");
    System.out.println("longVariableName: " + longVariableName);
    System.out.println("abcxyz: " + abcxyz);
  }

  public static int publicStaticMethod() {
    return 9000;
  }

  private static String privateStaticMethod(String first, String second) {
    return first + second;
  }
}