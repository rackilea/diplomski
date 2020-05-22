import java.util.regex.*;

class rTest {
  public static void main (String[] args) {
    String in = "Let's match 127.0.0.1 being valid, or this IP: 127.0.0.1 and joinTHIS.server.com or build 1.2";
    String re = "\\b((?:(?:[0-9]{1,3}\\.){3}[0-9]{1,3}|(?:[a-z0-9]+(?:-[a-z0-9]+)*\\.)+[a-z]{2,4}))\\b";
    Pattern p = Pattern.compile(re, Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(in);
    while (m.find()) {
      System.out.println(m.group(1));
    }
  }
}