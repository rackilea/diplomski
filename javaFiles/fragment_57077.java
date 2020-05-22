import java.lang.reflect.Type;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class JsonHelper {
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private static final Type TT_mapStringString = new TypeToken<Map<String,String>>(){}.getType();

    public static Map<String, String> jsonToMapStringString(String json) {
        Map<String, String> ret = new HashMap<String, String>();
        if (json == null || json.isEmpty())
            return ret;
         return gson.fromJson(json, TT_mapStringString);
    }
    public static String mapStringStringToJson(Map<String, String> map) {
        if (map == null)
            map = new HashMap<String, String>();
         return gson.toJson(map);
    }
}