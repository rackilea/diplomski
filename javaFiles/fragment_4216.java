import java.util.regex.*;

public class Test
{
  static final Pattern PH_Pattern = Pattern.compile("\\$\\{(\\d++)\\}");

  static String changePlaceholders(String orig)
  {
    Matcher m = PH_Pattern.matcher(orig);
    if (m.find())
    {
      StringBuffer sb = new StringBuffer(orig.length());
      do {
        m.appendReplacement(sb, "");
        sb.append("%").append(Integer.parseInt(m.group(1)) + 1);
      } while (m.find());
      m.appendTail(sb);
      return sb.toString();
    }
    return orig;
  }

  public static void main (String[] args) throws Exception
  {
    String s = "I am ${0}. He is ${1}";
    System.out.printf("before: %s%nafter:  %s%n", s, changePlaceholders(s));
  }
}