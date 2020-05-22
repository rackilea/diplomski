import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
    static boolean isValid(String x, int n, int m)
    {
       String pattern = "^\\d{1," + (n - 1) + "}[A-Za-z]{0," + (m - 1) + "}$";

       Pattern r = Pattern.compile(pattern);

       Matcher t = r.matcher(x);
       return t.find();
  }
public static void main( String args[] ){

  // String to be scanned to find the pattern.
  String line = "123abcdef";
  int n = 4, m = 4;

  if (isValid(line, n, m)) {
        System.out.println("FOUND");
  } else {
        System.out.println("NOT FOUND");
  }

  }
}