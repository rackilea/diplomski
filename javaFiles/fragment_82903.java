import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test {
public static void main(String[] args) {
    int[] A = { 1, 8, 7, 8, 9, 2, 1, 9, 6, 4, 3, 5, 4, 4, 4, 4, 4 };
    Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
    for (int i : A) {
        if (map.containsKey(i)) {
            map.put(i, map.get(i) + 1);
        } else {
            map.put(i, 1);
        }
    }
    System.out.println(sortByValue(map));
    List<Integer> keys = new ArrayList<Integer>(sortByValue(map).keySet());
    int maximumPossibleFrequency = map.get(keys.get(keys.size() - 1));
    for (int i = keys.size() - 1; i >= 0; i--) {
        if (map.get(keys.get(i)) < maximumPossibleFrequency) {
            break;
        } else {
            System.out.println(keys.get(i) + " => " + map.get(keys.get(i)));
        }
    }
}

public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> unsortMap) {

    List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(unsortMap.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
        public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
            return (o1.getValue()).compareTo(o2.getValue());
        }
    });

    Map<K, V> result = new LinkedHashMap<K, V>();
    for (Map.Entry<K, V> entry : list) {
        result.put(entry.getKey(), entry.getValue());
    }

    return result;

}
}