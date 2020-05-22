import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {
    public static void main(String args[]) {
        String str="bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32";
        String searchStr="bc";
        String []substrs=str.split("\\|"); //Split the input String at each '|'
        StringBuilder sb=new StringBuilder();
        Pattern pattern;
        Matcher matcher;
        int numberOfMatches;
        int sum=0;
        for(String s:substrs) {
            pattern=Pattern.compile(searchStr);
            matcher = pattern.matcher(s);
            numberOfMatches=0;        
            while (matcher.find()) {
                numberOfMatches++;
            }
            sb.append(String.valueOf(numberOfMatches)+"|");
            sum+=numberOfMatches;
        }
        sb.append(String.valueOf(sum));
        String out=sb.toString();
        System.out.println(out);
    }
}