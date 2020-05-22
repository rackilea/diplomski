import java.util.regex.*;

public class Test {
    public static void main(String[] args) {
        String text = "12 ab ^&";
        String regex = "(\\d+)|([a-z]+)|(\\p{Punct}+)";
        Matcher m = Pattern.compile(regex).matcher(text);
        while(m.find()) {
            System.out.println("\nmatched text: "+m.group());
            for(int i = 1; i <= m.groupCount(); i++) {
                System.out.println("   group "+i+"? "+(m.group(i) != null));
            }
        }
    }
}