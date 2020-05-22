import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HelloWorld {
  public static void main(String[] args) {
    Pattern p = Pattern.compile("(\\d{1,2}\\s[a-z]{3})\\.?\\s(\\d{1,2}:\\d{1,2})\\s-\\s([a-z]+):\\s(.+)", Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher("11 jan. 22:20 - Dam: Ik zal d'r zijn");

    while (m.find())
    {
      for (int i=1; i <= m.groupCount(); ++i)
        System.out.println("group " + i + ": " + m.group(i));
    }
  }
}