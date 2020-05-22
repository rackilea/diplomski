/**
 * AssociativeArray2D - Two dimensional associative array
 *
 * NOTE: Not thread-safe.
 *
 * @param <K1> type of first key
 * @param <K2> type of second key
 * @param <V> type of value
 */
public class AssociativeArray2D<K1, K2, V> {

    /* standard value if no value is in the map */
    private final V standard;
    private Map<K1, Map<K2, V>> map = new HashMap<K1, Map<K2, V>>();

    public AssociativeArray2D(V standard) {
        this.standard = standard;
}

    public static AssociativeArray2D<String, String, Boolean> getSSB() {
        return new AssociativeArray2D<String, String, Boolean>(false);
}

    public void add(K1 first, K2 second, V value) {
        Map<K2, V> m = map.get(first);
        if (m == null) {
            m = new HashMap<K2, V>();
            map.put(first, m);
        }
        m.put(second, value);
    }

    public V check(K1 first, K2 second) {
        Map<K2, V> m = map.get(first);
        if (m == null) {
            m = new HashMap<K2, V>();
            map.put(first, m);
            m.put(second, standard);
        }
        return m.get(second);
    }

    public static void main(String[] args) {
        AssociativeArray2D<String, String, Boolean> a = AssociativeArray2D.getSSB();

        if (a.check("1", "2")) {
            System.out.println("This, won't print!");
        }

        a.add("1", "2", true);

        if (a.check("1", "2")) {
            System.out.println("This, will print!");
        }
    }   
}