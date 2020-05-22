import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegEx {
    public static void main(String[] args) {
        String s = "\"uris\" : [\"www.google.com\", \"www.yahoo.com\"]";
        String r = "\"uris\".*?\\]";
        Pattern p = Pattern.compile(r);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group()); //"uris" : ["www.google.com", "www.yahoo.com"]
        }
    }
}