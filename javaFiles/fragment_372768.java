import java.util.regex.*;

public class foo {
  public static void main(String[] args) {
    String s = "Steve earns 9050$. Steve fuel cost is 500$ steve food cost is 800 Jack won 10000 steve marks in grad are 85 80 50 75 60";
    Pattern p = Pattern.compile("[\\D\\s]+[\\d\\s$\\.]+");
    Matcher m = p.matcher(s);

    while(m.find()) {
      System.out.println(m.group(0));
    }
  }
}