interface Node<N extends Node<N>> {
    void setNext(N next);
    N getNext();
}
interface Entry<K, V> extends Node<Entry<K, V>> {
    K getKey();
    void setValue(V value);
    V getValue();
}