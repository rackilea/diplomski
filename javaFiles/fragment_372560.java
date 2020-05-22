import java.io.*;
import java.util.*;

class Test {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File(args[0]), args[1]);
    while (in.hasNextLine()) {
      String line = in.nextLine();
      System.out.println("Line: " + line);
    }
    System.out.println("Exception if any: " + in.ioException());
  }
}