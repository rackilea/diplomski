public class BSTIterator<K extends Comparable<? super K>, V> 
    implements Iterator<SearchTree.Entry<K, V>> {
    // ...
}

public class BST<K extends Comparable<? super K>, V> 
    implements SearchTree<K, V> {

    @Override
    public Iterator<SearchTree.Entry<K, V>> iterator() {
        return new BSTIterator<>();
    }
}