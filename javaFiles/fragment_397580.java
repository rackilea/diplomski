import java.util.regex.*;

class Test {
  public static void main (String[] args) {
    String in = "num 123 num 1 num 698 num 19238 num 2134";
    Pattern p = Pattern.compile("([0-9]+) mun");
    Matcher m = p.matcher(new StringBuilder(in).reverse());
    if(m.find()) {
      System.out.println(new StringBuilder(m.group(1)).reverse());
    }
  }
}