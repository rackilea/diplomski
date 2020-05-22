package test;

import java.util.regex.Pattern;

public class Main {

  private static final Pattern P1 = Pattern.compile("//.*");
  private static final Pattern P2 = Pattern.compile("//.*");

  public static void main(String[] args) {
    System.out.println(P1.equals(P1));
    System.out.println(P1.equals(P2));
    System.out.println(P1.pattern().equals(P1.pattern()));
    System.out.println(P1.pattern().equals(P2.pattern()));
  }
}