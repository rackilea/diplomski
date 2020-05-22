import java.util.*;
import java.util.regex.*;

public class Main { 

    public static String[] tokenize(String text, String start, String end) {
        // old line:
        //Pattern p = Pattern.compile("(?s)"+Pattern.quote(start)+".*?"+Pattern.quote(end));
        // new line:
        Pattern p = Pattern.compile("(?sm)^"+Pattern.quote(start)+".*?"+Pattern.quote(end)+"$");

        Matcher m = p.matcher(text);
        List<String> tokens = new ArrayList<String>();
        while(m.find()) {
            tokens.add(m.group());
        }
        return tokens.toArray(new String[]{});
    }

    public static void main(String[] args) {
        String text = "Name abc" + "\n" +
            "sadghsagh"          + "\n" +
            "hsajdjah Name"      + "\n" +
            "ggggggggg"          + "\n" +
            "!!!"                + "\n" +
            "Name ggg"           + "\n" +
            "dfdfddfdf Name"     + "\n" +
            "!!!"                + "\n" +
            "Name hhhh"          + "\n" +
            "sahdgashdg Name"    + "\n" +
            "asjdhjasdh"         + "\n" +
            "sadasldkalskd"      + "\n" +
            "asdjhakjsdhja"      + "\n" +
            "!!!";
        String[] tokens = tokenize(text, "Name", "!!!");
        int n = 0;
        for(String t : tokens) {
            System.out.println("---------------------------\n"+(++n)+"\n"+t);
        }
    }
}