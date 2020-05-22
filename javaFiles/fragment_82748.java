import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {

    // Test method
    public static void main(String[] args) {
        Map.Entry<String, String> entry1 = newEntry("Key1", "Value1");
        Map.Entry<String, String> entry2 = newEntry("Key2", "Value2");

        System.out.println("HashMap");
        MyMap<String, String> hashMap = new MyHashMap<>();
        hashMap.put(entry1);
        hashMap.put(entry2);

        for (String key : hashMap.keySet()) {
            System.out.println(key + " = " + hashMap.get(key));
        }

        System.out.println("\nTreeMap");
        MyMap<String, String> treeMap = new MyTreeMap<>();
        treeMap.put(entry1);
        treeMap.put(entry2);


        for (String key : treeMap.keySet()) {
            System.out.println(key + " = " + treeMap.get(key));
        }
    }


    /**
     * Creates a new Entry object given a key-value pair.
     * This is just a helper method for concisely creating a new Entry.
     * @param key   key of the entry
     * @param value value of the entry
     * 
     * @return  the Entry object containing the given key-value pair
     */
    private static <K,V> Map.Entry<K,V> newEntry(K key, V value) {
        return new AbstractMap.SimpleEntry<>(key, value);
    }

    /**
     * An enhanced Map interface.
     */
    public static interface MyMap<K,V> extends Map<K,V> {

        /**
         * Puts a whole entry containing a key-value pair to the map.
         * @param entry 
         */
        public default V put(Entry<K,V> entry) {
            return put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * An enhanced HashMap class.
     */
    public static class MyHashMap<K,V> extends HashMap<K,V> implements MyMap<K,V> {}

    /**
     * An enhanced TreeMap class.
     */
    public static class MyTreeMap<K,V> extends TreeMap<K,V> implements MyMap<K,V> {}
}