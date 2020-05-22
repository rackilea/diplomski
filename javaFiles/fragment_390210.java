import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) throws Exception
    {

        String temp = "contains(text(),\"something\")]";
        String pattern = "^contains\\(text\\(\\),\"(.*)\"\\)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(temp);
        if(m.find())
        {   
            String value = m.group(0);
            System.out.println(value+" <-- value"); //TODO remove debugging code
//            type = CONTAINS;  //<- no idea what this was for
            int pointer = m.end();
            System.out.println(pointer+" <-- pointer"); //TODO remove debugging code

            System.out.println(m.group(1)+" <-- m.group(1)");

            System.out.println(temp.substring(pointer, pointer+1)
                +" <-- temp.substring(pointer, pointer+1)"); //TODO remove debugging code
        }
    }
}