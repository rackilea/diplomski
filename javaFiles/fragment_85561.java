import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UniqueOrderedBiMap<K, V>implements Map<K, V> {
    private Map<K, V> orderedMap;
    private HashMap<V, K> valueMap;

    public UniqueOrderedBiMap() {
        this(new LinkedHashMap<K,V>());
    }

    public UniqueOrderedBiMap(Map<K, V> underlyingMap) {
        orderedMap = underlyingMap;
        valueMap = new HashMap<V, K>(orderedMap.size());

        for(Map.Entry<K, V> e : orderedMap.entrySet()) {
            if(!valueMap.containsKey(e.getValue())) { // Duplicate value
                // could instead fail softly by removing the associated item from the map, but this seems cleaner/clearer.
                // generally this constructor should be passed an empty map anyways
                throw new IllegalArgumentException("Duplicate value "+e.getValue()+" found in underlying map.");
            }
            valueMap.put(e.getValue(), e.getKey());
        }
    }

    @Override
    public int size() {
        return orderedMap.size();
    }

    @Override
    public boolean isEmpty() {
        return orderedMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return orderedMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        // more efficient than iterating over the map
        return valueMap.containsKey(value);
    }

    @Override
    public V get(Object key) {
        return orderedMap.get(key);
    }

    public K getKey(V value) {
        return valueMap.get(value);
    }

    // Likely want to implement a forcePut(K, V) method like Guava's BiMaps do
    @Override
    public V put(K key, V value) {
        if(valueMap.containsKey(value)) {
            throw new IllegalArgumentException("Cannot insert non-unique value "+value);
        }
        V ret = orderedMap.put(key, value);
        valueMap.remove(ret);
        valueMap.put(value, key);
        return ret;
    }

    @Override
    public V remove(Object key) {
        V ret = orderedMap.remove(key);
        valueMap.remove(ret);
        return ret;
    }

    public K removeKey(V value) {
        K ret = valueMap.remove(value);
        orderedMap.remove(ret);
        return ret;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        // Existing Map implementation's putAll have some optimizations we
        // could take advantage of, but this isn't unreasonable for a first pass
        for(Entry<? extends K, ? extends V> e : m.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    @Override
    public void clear() {
        orderedMap.clear();
        valueMap.clear();
    }

    @Override
    public Set<K> keySet() {
        return orderedMap.keySet();
    }

    @Override
    public Collection<V> values() {
        return orderedMap.values();
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        return orderedMap.entrySet();
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof UniqueOrderedBiMap) {
            UniqueOrderedBiMap<?,?> map = (UniqueOrderedBiMap<?,?>)o;
            return orderedMap.equals(map.orderedMap); 
        }
        return false;
    }

    @Override
    public int hashCode() {
        return orderedMap.hashCode();
    }

    @Override public String toString() {
        return orderedMap.toString();
    }

    public static void main(String[] args) {
        String[] names = { "Marcus", "Jim", "Tom", "Sam" };
        String[] grades = { "A", "B", "D", "F" };

        UniqueOrderedBiMap<String,String> insertionMap = new UniqueOrderedBiMap<>();
        UniqueOrderedBiMap<String,String> sortedMap = new UniqueOrderedBiMap<>(new TreeMap<String,String>());

        for(int i = 0; i < names.length; i++) {
            insertionMap.put(names[i], grades[i]);
            sortedMap.put(names[i], grades[i]);
        }

        // Poor man's assert
        System.out.println(insertionMap.toString().equals("{Marcus=A, Jim=B, Tom=D, Sam=F}"));
        System.out.println(sortedMap.toString().equals("{Jim=B, Marcus=A, Sam=F, Tom=D}"));

        insertionMap.put("Tom", "C");
        sortedMap.put("Tom", "C");
        System.out.println(insertionMap.toString().equals("{Marcus=A, Jim=B, Tom=C, Sam=F}"));
        System.out.println(sortedMap.toString().equals("{Jim=B, Marcus=A, Sam=F, Tom=C}"));

        try {
            insertionMap.put("Sam", "C");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            sortedMap.put("Sam", "C");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        insertionMap.remove("Tom");
        sortedMap.remove("Tom");
        insertionMap.put("Sam", "C");
        sortedMap.put("Sam", "C");
        System.out.println(insertionMap.toString().equals("{Marcus=A, Jim=B, Sam=C}"));
        System.out.println(sortedMap.toString().equals("{Jim=B, Marcus=A, Sam=C}"));

        insertionMap.removeKey("A");
        sortedMap.removeKey("A");
        System.out.println(insertionMap.toString().equals("{Jim=B, Sam=C}"));
        System.out.println(sortedMap.toString().equals("{Jim=B, Sam=C}"));
    }
}