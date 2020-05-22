import java.util.regex.*;

class Test {
  public static void main (String[] args) {
    String in = "num 123 num 1 num 698 num 19238 num 2134";
    Pattern p = Pattern.compile(".*num ([0-9]+)");
    Matcher m = p.matcher(in);
    if(m.find()) {
      System.out.println(m.group(1));
    }
  }
}