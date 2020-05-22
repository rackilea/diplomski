import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class List {
    public static void main(String[] args) {

        int i = 0;
        char[] Wanted = new char[3];// Instead of array any dynamic collection should be used here. Since I'm not familiar with Java collections enough, Im leaving array here for correct work
        Pattern pat = Pattern.compile("\\b\\w+\\b");
        String Motherstring = " F5 F4 E3 ";
        Matcher m = pat.matcher(Motherstring);
        while (pat.find()) {
            Wanted[i]= pat.group();
            i++;
        }
    }
}