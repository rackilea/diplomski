import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {

        Pattern p = Pattern.compile("name (.+) address (.+) birthday (.+)");

        String text = "name Marioka address 97 Garderners Road birthday 12-11-1982";

        Matcher m = p.matcher(text);

        if (m.matches()) {
            System.out.println(m.group(1) + "\n" + m.group(2) + "\n"
                    + m.group(3));
        } else {
            System.out.println("String does not match");
        }
    }
}