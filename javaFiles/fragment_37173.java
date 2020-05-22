public class JCollated<K extends Comparable<? super K>, V extends Comparable<? super V>> {
    ...

    public List<JLabeled<K, V>> getAll() {
        ...
    }

    public void createKey(K key) {
        ...
    }
}