import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpression{

    public static void main(String[] args){

        Pattern mPattern = Pattern.compile("^love (.*?) way you (.*?)$");
        Matcher matcher = mPattern.matcher("love the way you lie");
        if(matcher.find()){
            String[] match_groups = new String[matcher.groupCount() + 1];
                System.out.println(String.format("groupCount: %d", matcher.groupCount() + 1));
                for(int j = 0;j<matcher.groupCount() + 1;j++){
                    System.out.println(String.format("j %d",j));
                    match_groups[j] = matcher.group(j);
                    System.out.println(match_groups[j]);
                }
        }

    }
}