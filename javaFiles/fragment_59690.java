package edu.mew.test.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpPatternTester {

  public static void main(String[] args) {
    String s1 = "filename()[].txt";
    Pattern p = Pattern.compile(".*\\(\\)\\[\\].*");
    Matcher m1 = p.matcher(s1);
    System.out.println(m1.matches());
    String s2 = "filename.txt";
    Matcher m2 = p.matcher(s2);
    System.out.println(m2.matches());
  }

}