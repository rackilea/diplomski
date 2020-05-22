import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A {

    @SuppressWarnings("serial")
    public static void main(String[] args) {
        Map<String, Set<MyClass>> aMap = new HashMap<>();
        aMap.put("firstKey", new HashSet<MyClass>() {
            {
                add(new MyClass(1, "a"));
                add(new MyClass(2, "b"));
            }
        });
        aMap.put("secondKey", new HashSet<MyClass>() {
            {
                add(new MyClass(3, "c"));
            }
        });
        for (String eachKey : aMap.keySet()) {
            System.out.println(eachKey + " :" + aMap.get(eachKey));
        }
    }

}