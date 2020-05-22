import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiMap {
    public static void main(String[] args) {
        final Map<String, List<String>> map = new HashMap<String, List<String>>();

        final List<String> valSetOne = new ArrayList<String>();
        valSetOne.add("www.google.com");
        valSetOne.add("test");

        final List<String> valSetTwo = new ArrayList<String>();
        valSetTwo.add("www.gmail.com");
        valSetTwo.add("Test");

        map.put("1", valSetOne);
        map.put("2", valSetTwo);

        final List<String> values = map.get("1");
        System.out.println("Before changing: " + values.get(1));
        values.set(1, "newTest");
        System.out.println("After changing: " + values.get(1));
    }
}