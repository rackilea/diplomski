import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    var scanner = new Scanner("ab");

    System.out.println(scanner.findInLine("."));        // output: a
    System.out.println(scanner.findInLine("(?<=^.).")); // output: b
  }
}