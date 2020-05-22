import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;


public class Test
{
    public static void main(String[] args) throws IOException, JSONException {
        String serverResponse = "[\"VU\", \"Vanuatu\", [\"Pacific/Efate\", \"(GMT+11:00) Efate\"], \"VN\", \"Vietnam\", [\"Asia/Saigon\", \"(GMT+07:00) Hanoi\"]]";
        Map<String, Object> prop, innerProp;
        List<Object> arr = new ArrayList<>(), obj;

        String pattern = "\"([^\"]*)\",\\s*\"([^\"]*)\",\\s*\\[\"([^\"]*)\",\\s*\"([^\"]*)\"\\]";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(serverResponse);

        while (m.find()) {
            prop = new HashMap<>();
            prop.put("id", m.group(1));
            prop.put("name", m.group(2));

            innerProp = new HashMap<>();
            innerProp.put("id", m.group(3));
            innerProp.put("name", m.group(4));

            prop.put("timezones", innerProp);
            arr.add(prop);
        }


        JSONArray jsonArray = new JSONArray(arr);
        System.out.println(jsonArray.toString());
    }
}