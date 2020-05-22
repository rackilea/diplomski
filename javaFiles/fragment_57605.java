import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;

public class GsonMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        String apikey = "asfasdfasfdasdfasdfa";
        map.put("api_key", apikey);
        String name = "yo";
        String city = "Solares";
        map.put("venue_queries", "[{\"name\":\""+name+"\", \"location\": {\"locality\": \""+city+"\"}}]");
        Gson gson = new Gson();
        String json = gson.toJson(map);
        System.out.println("Resulting JSON:" + json);
        map = gson.fromJson(json, map.getClass());
        System.out.println("Resulting map values:");
        for (Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key:" + entry.getKey() + ", value:" + entry.getValue());
        }
    }
}