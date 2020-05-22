import java.util.regex.*;
public class AddtheNumbers {

    public static void main(String[] args) {
       Pattern p = Pattern.compile("-?\\d+");
       Matcher m = p.matcher("bajsd 7 jns 87 5");
       while (m.find()) {
         System.out.println(m.group());
       }
    }
}