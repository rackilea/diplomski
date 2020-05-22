import java.text.ParseException;
import java.util.StringTokenizer;

public class stringtok2
{
    public static void main(String[] argv)
    throws Exception
    {
        String data="ABC";
        final StringTokenizer stoken=new StringTokenizer(data.toString(),";");
        if (!stoken.hasMoreTokens()) throw new ParseException("Some msg",0);
        final String test=stoken.nextToken();
    }

}