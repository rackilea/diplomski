import java.util.HashMap;
import java.util.Map;

public class StackOverflowExample {

    public static void a() {
        Map<String, String> map = new HashMap<String, String>();
        map.putAll(b());

    }

    private static Map<String, String> b() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "a");
        a();
        return map;
    }

    public static void main(String[] args) {
        a();
    }
}