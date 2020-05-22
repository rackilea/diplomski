package persistence;

public interface GenericDao<K, V> {
    List<V> find();
    V find(K id);
    K save(V value);
    void update(V value);
    void delete(V value);
};