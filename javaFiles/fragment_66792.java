import java.util.regex.Matcher;
import java.util.regex.Pattern;

...

 public static void main(String[] args) {
    String ex = "A >= 10 AND B <= 20 OR C in ('3', '4')";
    String regex ="(\\(.*\\)|[^\\s]+)+";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(ex);
    while(m.find()) {
       System.out.println(m.group(1));
    }
 }