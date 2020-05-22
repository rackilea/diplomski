import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
private static Pattern telp1 = Pattern.compile("\\((\\d+)\\)-?(\\d+)\\D*?(\\d*)");
private static Pattern telp2 = Pattern.compile("(\\d+)-?(\\d+)\\D*?(\\d*)");

   public static void testNomor(String s){

       Matcher m = telp1.matcher(s);
       Matcher m2 = telp2.matcher(s);

             if (m.matches()) {
       System.out.println(s + "\nArea Code = " +m.group(1)+"\nPhone Number = " + m.group(2) + m.group(3) + "\n");
   } else if (m2.matches()) {
       System.out.println(s + "\nArea Code = " +m2.group(1)+"\nPhone Number = " + m2.group(2) + m2.group(3) + "\n");

   }  else {
       System.out.println(s+" phone number is invalid");
   }
}