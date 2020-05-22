import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ExampleMainOne {

public static void main(String[] args) {

    JSONObject jo = null;
    try {
        jo = new JSONObject("{\"city\":\"chicago\",\"name\":\"jon doe\",\"age\":\"22\"}");
    } catch (JSONException e) {
        e.printStackTrace();
    }
    Set<String> keys = jo.toMap().keySet();

    System.out.println(keys);    //[city, name, age]

    }

 }