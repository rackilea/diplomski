package org.group;

import java.util.Arrays;
import java.util.List;

public class Person {
  public void method1(String id, String number) {
    // some code
    List<String> list = getList(number);
    // some code
  }

  public List<String> getList(String number) {
    return Arrays.asList(number);
  }

  public static void main(String[] args) {
    // Should not be intercepted
    new Person().getList("22");
    // Should be intercepted
    new Person().method1("John Doe", "11");
  }
}