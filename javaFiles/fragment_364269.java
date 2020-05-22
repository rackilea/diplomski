import java.io.*;
import java.util.*;

public class MyFinal3 {

  static void exceptionFinal() throws RuntimeException {
    System.out.println("Inside exceptionFinal");
    throw new RuntimeException();
  }

  public static void main(String[] args) {
    double myDouble[] = new double[5];
    try {
      exceptionFinal();
      System.out.println("Access element sixth :" + myDouble[6]);
    } catch (RuntimeException eE) {
      System.out.println("Exception thrown: 1");
    } catch (Exception eE) {
      System.out.println("Exception thrown: 2");
    }

    finally {
      System.out.println("Exception end");
    }
    System.out.println("Out of the block");
  }
}