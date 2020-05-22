public class Dump {
  public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    int line = 0;
    while (scanner.hasNextLine()) {
      System.out.format("%d: %s%n", line++, scanner.nextLine());
    }
  }
}