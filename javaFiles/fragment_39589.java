import java.util.Objects;

public class Test {

  public final static Long ITERATIONS = 100000000L; 

  public static void main(String args[]) {
    withFnCalls();
    noFnCalls();
    withFnCalls();
    noFnCalls();
    withFnCalls();
    noFnCalls();
    withFnCalls();
    noFnCalls();
    withFnCalls();
    noFnCalls();
  }
  public static void noFnCalls() {
    long startTime = System.currentTimeMillis();
    Object x = new Object();
    Long i;
    for (i = 0L; i < ITERATIONS; i++) {
      boolean t = x == null;
    }
    long estimatedTime = System.currentTimeMillis() - startTime;
    System.out.println("noFnCalls ellapsed time: " + estimatedTime);
  }

  public static void withFnCalls() {
    long startTime = System.currentTimeMillis();
    Object x = new Object();
    Long i;
    for (i = 0L; i < ITERATIONS; i++) {
      boolean t = Objects.isNull(x);
    }
    long estimatedTime = System.currentTimeMillis() - startTime;
    System.out.println("withFnCalls ellapsed time: " + estimatedTime);
  }
}