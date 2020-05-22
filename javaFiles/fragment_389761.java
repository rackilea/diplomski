package com.example;
public class FaxNumber {
  private String value;
  // getter/setter

  public static FaxNumber parse(String s) {
    FaxNumber n = new FaxNumber();
    n.value = s;
    return n;
  }

  public static String print(FaxNumber n) {
    return n.value;
  }
}