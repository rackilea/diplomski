package com.stackoverflow.examplepackage;

public class Main {
  private String privateString = "I'm private";

  public static void main(String[] args) {
    new Main().hello();
  }
  public void hello(){
    System.out.println("Hello world - " + privateString);
  }
}