import java.util.regex.*;

public class Main {
  public static void main(String[] args) throws Exception {

    String text = "test a=\"1\" b=\"2\" c=\"3\" bar d=\"4\" e=\"5\"";
    System.out.println(text + "\n");

    Matcher m1 = Pattern.compile("([a-z]*)((?:[ \t]+[a-z]=\"[0-9]\")*)").matcher(text);

    while(m1.find()) {

      System.out.println(m1.group(1));

      Matcher m2 = Pattern.compile("([a-z])=\"([0-9])\"").matcher(m1.group(2));

      while (m2.find()) {
        System.out.println("  " + m2.group(1) + " -> " + m2.group(2));
      }
    }
  }
}