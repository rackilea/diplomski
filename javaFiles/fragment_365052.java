public K exactKey(int index) {
    if (index < 0 || index > size() - 1) {
        throw new ArrayIndexOutOfBoundsException();
    }
    return getExactKey(root, index);
}

private K getExactKey(Entry<K, V> e, int index) {
    if (e.left == null && index == 0) {
        return e.key;
    }
    if (e.left == null && e.right == null) {
        return e.key;
    }
    if (e.left != null && e.left.weight > index) {
        return getExactKey(e.left, index);
    }
    if (e.left != null && e.left.weight == index) {
        return e.key;
    }
    return getExactKey(e.right, index - (e.left == null ? 0 : e.left.weight) - 1);
}