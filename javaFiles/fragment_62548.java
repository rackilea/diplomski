import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackOver {

    public static void main(String[] args) {

        // Log File Content
        String LOG_FILE_CONTENT = "Level {INFO} field1 {value1} field2 {value2} field3 {value3} field4 {value4} LOG_TYPE field5 {value5} field6 {value6} field7 {value7}";

        // Regex
        String pattern = "([a-zA-Z0-9]+)(\\s+)(\\{[a-zA-Z0-9]+)(\\})";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(LOG_FILE_CONTENT);

        // Mapper
        ParserResult pr = new ParserResult();
        pr.fieldValueMap = new HashMap<>();
        while(m.find()){
            String group = m.group();
            pr.fieldValueMap.put(group.split(" ")[0], group.split(" ")[1]);
        }

        pr.fieldValueMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

}

class ParserResult {
    String logLineType;
    Map<String, String> fieldValueMap;
}