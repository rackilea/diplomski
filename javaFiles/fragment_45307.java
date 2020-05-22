package de.scrum_master.app;

import java.util.Random;

public class Helper {
  private static final Random RANDOM = new Random();

  public static String doStuff(String myField) {
    if (RANDOM.nextBoolean())
      throw new RuntimeException("uh-oh!");
    return "processed " + myField;
  }
}