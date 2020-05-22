package main.java.aop.field;

class FieldAspect {
  static String getField() {
    return "Andy";
  }
}

package main.java.aop.extend;

public class AbstractTracing {

  @Field
  public static String x;

  public static void traceMethod() {
    System.out.println("In trace method of AbstractTracing class : " + x);
  }   

}