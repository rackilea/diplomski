import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main{
    public static void main(String[] args) {
        String s = "1.234,567.89";
        Pattern p = Pattern.compile("(?=(\\d+[.,]\\d{2}))(?=((?:\\d+[.,]){2,}?\\d{2})?)(?=((?:\\d+[.,])+\\d{2}))");
        Matcher m = p.matcher(s);

        List<String> al = new ArrayList<>();
        Set<String> hs = new HashSet<>();

        while(m.find()) {
            al.add(m.group(1));
            al.add(m.group(2));
            al.add(m.group(3));
        }

        al.removeAll(Collections.singleton(null));
        hs.addAll(al);
        al.clear();
        al.addAll(hs);

        System.out.println(al);
    }
}