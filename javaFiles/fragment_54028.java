import java.util.regex.*;

public class SimpleRegexTest {
    public static void main(String[] args)
    {
        String sampleText = " May  4 21:07:00 getz vmunix:     Physical: 6289408 Kbytes, lockable: 4604660 Kbytes, available: 5417880 Kbytes";
        String sampleRegex = "Physical: (\\d+)";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(sampleRegex);
        java.util.regex.Matcher m = p.matcher(sampleText);

        if (m.find()) {
            String matchedText = m.group(1);
            System.out.println(matchedText);
        } else {
            System.out.println("didn't match");
        }
    }
}