import java.util.HashMap;

public class ObjectReferences {
    static HashMap<String, StringBuffer> map1 = new HashMap<>();
    static HashMap<String, StringBuffer> map2 = new HashMap<>();

    public static void addToBoth(StringBuffer sb) {
        map1.put("One",sb);
        map2.put("Two",sb);
    }

    public static void main(String[] args) {
        StringBuffer foo = new StringBuffer("wat");
        addToBoth(foo);
        map1.get("One").append("er");
        System.out.println(map2.get("Two").toString());
    }
}