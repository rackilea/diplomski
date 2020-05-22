import java.util.*;

public class Example {
    public static void main(String args[]){
        Map<String, String> source1 = new HashMap<>();
        source1.put("a", "b");
        source1.put("c", "d");
        Map<String, String> source2 = new HashMap<>();
        source2.put("c", "a");
        source2.put("p", "e");

        Map<String, String> target = new HashMap<>();
        target.putAll(source1);
        target.putAll(source2);

        for (var entry : target.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}