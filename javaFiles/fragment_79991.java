import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackOverflow54842971 {

    private static Map<String, String> map;

    public static void main(String[] args) {
        // preparing test data
        map = new HashMap<>();
        map.put("role", "Admin");
        map.put("userid", "666");

        // original query string
        String query = "SELECT * FROM USERS WHERE ID = '@userid@' AND emailid = 'xyz@gmail.com' AND ROLE = '@role@' ";

        // regular expression to match everything between '@ and @' with capture group
        // omitting single quotes
        Pattern p = Pattern.compile("'(@[^@]*@)'");
        Matcher m = p.matcher(query);
        while (m.find()) {
            // every match will be replaced with value from getReportManagerKeyValue
            query = query.replace(m.group(1), getReportManagerKeyValue(m.group(1).replaceAll("@", "")));
        }
        System.out.println(query);
    }

    // you won't need this function
    private static String getReportManagerKeyValue(String key) {
        System.out.println("getting key " + key);
        if (!map.containsKey(key)) {
            return "'null'";
        }
        return map.get(key);
    }
}