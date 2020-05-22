import java.util.regex.*;

public class Test
{
    public static void main(String[] args)
    {
        String text = "EQ=ENABLED,QLPUB=50,EPRE=ENABLED,T200=44-31-41-90-90-90-135";
        Pattern pattern = Pattern.compile("^EQ=ENABLED,QLPUB=[^,]*,EPRE=ENABLED");
        Matcher matcher = pattern.matcher(text);
        if (matcher.lookingAt())
        {
            System.out.println(matcher.group());
        }
    }
}