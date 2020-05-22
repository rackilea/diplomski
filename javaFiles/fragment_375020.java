import java.util.HashMap;
import java.util.Map;

public class Flip {


    public static Map <String, Map<String, String>> flip(Map <String, Map<String, String>> map){
        Map <String, Map<String, String>> result = new HashMap<String, Map<String, String>>();
        for (String key : map.keySet()){
            for (String key2 : map.get(key).keySet()){
                if (!result.containsKey(key2)){
                    result.put(key2, new HashMap<String, String>());
                }

                result.get(key2).put(key, map.get(key).get(key2));
            }
        }


        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map <String, Map<String, String>> map = new HashMap<String, Map<String, String>>();

        map.put("Mickey", new HashMap<String, String>());
        map.get("Mickey").put("Physics", "1.1");
        map.get("Mickey").put("Maths", "1.2");

        map.put("Minnie", new HashMap<String, String>());
        map.get("Minnie").put("Physics", "1.1");
        map.get("Minnie").put("Chemistry", "1.3");

        System.out.println(map);

        System.out.println(flip(map));
    }

}