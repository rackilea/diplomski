class RBTree<T extends Comparable<T>> {
    public class Node<T extends Comparable<T>> {
        T value;
    }
}

public class RBMap<K extends Comparable<K>, V> {

    RBTree<Pair> pair;

    public class Pair implements Comparable<Pair> {
        K key;
        V value;

        @Override
        public int compareTo(Pair o) {
            return this.key.compareTo((K) o.key);
        }
    }
}