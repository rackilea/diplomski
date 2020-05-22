import java.util.regex.*;
class Test {
  public static void main(String[] args) {
    Pattern pat = Pattern.compile("\\b[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.-]+\\b");
    Matcher match = pat.matcher("<li>info@napoleoninvestment.net</li>");
    System.out.println("I found this: "+ match.find() + " with expression: " + pat);
  }
}