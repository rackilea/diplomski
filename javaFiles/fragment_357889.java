import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Test
{ 
    public static void main(String[] args)
    {
        String someString = "\"Multiple quote test\" not in quotes \"inside quote\" \"A work in progress\"";
        Pattern p = Pattern.compile("((?<=(\"))[\\w ]*(?=(\"(\\s|$))))|((?<!\")\\w+(?!\"))");
        Matcher m = p.matcher(someString);

        while(m.find()) {
            System.out.println("'" + m.group() + "'");
        }
    }
}