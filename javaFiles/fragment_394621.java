import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        String phrase = "«User» of the «application»";
        Pattern p = Pattern.compile("«\\w+»");
        Matcher m = p.matcher(phrase);
        while (m.find()) {
            list.add(m.group().replaceAll("«", "").replaceAll("»", ""));
        }
        String words[] = list.toArray(new String[0]);
        System.out.println(Arrays.toString(words));
    }
}