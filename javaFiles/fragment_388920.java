package org.test.stackoverflow;

import java.util.Collections;
import java.util.List;

public class StaticUtil {
  public static void Wrapper() {
    getSomethingMethod(null, null, false, Collections.<String>emptyList());
  }

  private static List<String> getSomethingMethod(Object[] obj,
      String[] str, boolean flag, List<String> aList){ 
    System.out.println("I happen!");
    return aList;
  }
}