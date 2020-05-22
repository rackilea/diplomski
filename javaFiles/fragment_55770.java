public class ConsoleDemo {
  public static void main(String[] args) {
    String[] data = { "\u250C\u2500\u2500\u2500\u2500\u2500\u2510", 
        "\u2502Hello\u2502",
        "\u2514\u2500\u2500\u2500\u2500\u2500\u2518" };
    for (String s : data) {
      System.out.println(s);
    }
    for (String s : data) {
      System.console().writer().println(s);
    }
  }
}