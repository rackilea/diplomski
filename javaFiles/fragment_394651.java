import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex8601
{
  static final Pattern r8601 = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})T((\\d{2}):"+
                               "(\\d{2}):(\\d{2})\\.(\\d{3}))((\\+|-)(\\d{2}):(\\d{2}))");


  //2010-09-18T10:00:00.000+01:00

  public static void main(String[] args)
  {
    String thisdate = "2010-09-18T10:00:00.000+01:00";
    Matcher m = r8601.matcher(thisdate);
    if (m.lookingAt()) {
      System.out.println("Year: "+m.group(1));
      System.out.println("Month: "+m.group(2));
      System.out.println("Day: "+m.group(3));
      System.out.println("Time: "+m.group(4));
      System.out.println("Timezone: "+m.group(9));
    } else {
      System.out.println("no match");
    }
  }
}