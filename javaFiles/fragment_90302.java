import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchReverseString {
    public static void main(String []args) {
        String str = "HIHIIH";
        String strToSearch = "HI";
        String strToSearchReversed = new StringBuffer(strToSearch).reverse().toString();
        Pattern strPattern = Pattern.compile(Pattern.quote(strToSearchReversed));
        Matcher matcher = strPattern.matcher(str);
        int counter = 0;
        while(matcher.find()) {
            ++counter;
        }
        System.out.println(strToSearch+" was spelt as "+strToSearchReversed+" "+counter+" times");
    }
}