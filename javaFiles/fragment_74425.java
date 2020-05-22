// Example1.java
public class Example1 {
  public static void example1() {
    System.out.println("Example1");
  }
}

// Example2.java
import static Example1.*; // THIS IMPORT FAILS
public class Example2 {
  public static void main(String... args) {
    example1();
  }
}