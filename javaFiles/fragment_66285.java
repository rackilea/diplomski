import java.util.regex.Pattern;

public class Match {
    public static void main(String[] args) { 
        String s1 =  "<h2> blabla </h2>"; 
        String s2 = " <h2> some other string </h2>";
        final String regex = "<h2>(.)*blabla(.)*<\\/h2>";  

        boolean b1 = Pattern.matches(regex, s1);
        boolean b2 = Pattern.matches(regex, s2);

        System.out.printf("the value of b1 is %b\n", b1);
        System.out.printf("the value of b2 is %b\n", b2);
    }
}