import java.util.*;

class Test {
    public static void main(String[] args) {
        Map<String, Object> x = new HashMap<>();
        x.put("foo", "bar");
        x.put("number", 0);
        Map<String, String> y = (Map<String, String>) (Object) x;
        // This is fine
        System.out.println(y.get("foo"));

        // This goes bang! It's trying to cast an Integer to a String
        System.out.println(y.get("number"));
    }
}