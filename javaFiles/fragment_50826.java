package persistence;

public interface GenericDao<K, V> {
    V find(K key);
    List<V> find();
    K save(V value);
    void update(V value);
    void delete(V value);
}