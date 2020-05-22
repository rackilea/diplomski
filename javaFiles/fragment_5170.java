import java.text.ParseException;
import java.util.StringTokenizer;

public class stringtok
{ 
  public static void main(String[] argv)
  throws Exception
  {
      String data="ABC";
      final StringTokenizer stoken=new StringTokenizer(data.toString(),";");
      if (stoken.hasMoreTokens()) {
          final String test=stoken.nextToken();
      } else {
          throw new ParseException("Some msg",0);
      }
  }
}