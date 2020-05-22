import java.util.regex.Pattern;
import java.util.regex.Matcher;

class regcheck
{
    private static Pattern twopart = Pattern.compile("(\\d+\\.?\\d*),?\\s*?(\\d+\\.?\\d*)");

    public static void checkString(String s)
    {
        Matcher m = twopart.matcher(s);
        if (m.matches()) {
            System.out.println(m.group(1) +" " + m.group(2));
        } else {
            System.out.println(s + " does not match.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Parts of strings are ");
        checkString("##some text");
        checkString("123,     4567");
        checkString("123,   342");
        checkString("45.45   4.3");
        checkString("3.78,  23.78");

  }  
}