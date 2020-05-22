public class MapListener<K, V> implements Map<K, V> {

    private final Map<K, V> delegatee;

    public MapListener(Map<K, V> delegatee) {
        this.delegatee = delegatee;
    }

    // implement all Map methods, with callbacks you need.

}