import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        TreeMap<Double, TreeMap<Integer, String>> map = new TreeMap<>();
        add(2.5, 5, "wrong value 1", map);
        add(3, 2, "wrong value 2", map);
        add(2.5, 3, "good value", map);

        System.out.println(map.pollFirstEntry().getValue().pollFirstEntry().getValue());
    }
    public static void add(double val1, int val2, String val3, TreeMap<Double, TreeMap<Integer, String>> map) {
        TreeMap<Integer,String> subMap = map.get(val1);
        if (subMap == null) {
            subMap = new TreeMap<Integer, String>();
            map.put(val1, subMap);
        }
        subMap.put(val2, val3);
    }

}