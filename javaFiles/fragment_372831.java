public Node<T> find(Comparable<T> target) {
    Node<T> current = root;
    int comp = target.compareTo(current.data);
    while (comp != 0) {
        if (comp < 0)
            current = current.leftChild;
        else
            current = current.rightChild;
        if(current == null)
            return null;
    }
    return current;
}