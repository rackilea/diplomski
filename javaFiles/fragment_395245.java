import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPattern {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("#[0-9]{4}:");

        String text = "#1233:#3433:abc#3993: #a343:___#8888:ki";
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}