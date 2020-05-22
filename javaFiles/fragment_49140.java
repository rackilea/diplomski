package com.company;

import java.io.PrintStream;

public class MyClass {
  public static void main(String[] paramArrayOfString) {
    paramArrayOfString = publicStaticMethod();
    String str = a("abc", "xyz");
    System.out.println("longVariableName: " + paramArrayOfString);
    System.out.println("abcxyz: " + str);
  }

  public static int publicStaticMethod() {
    return 9000;
  }

  private static String a(String paramString1, String paramString2) {
    return paramString1 + paramString2;
  }
}