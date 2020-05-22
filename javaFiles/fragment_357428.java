import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws Exception {

        String text = "auser1 home1b\n" +
                "auser2 home2b\n" +
                "auser3 home3b";

        Matcher m = Pattern.compile("(?m)^.*$").matcher(text);

        while (m.find()) {
            System.out.println("line = " + m.group());
        }
    }
}