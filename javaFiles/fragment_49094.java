private boolean contains(Node node, Integer value) {
    if (node.getValue() == value) {
        return true;
    }

    boolean contains = false;
    if (node.hasLeft()) {
        contains = contains(node.getLeft(), value);
    }
    if (!contains && node.hasRight()) {
        contains = contains(node.getRight(), value);
    }

    return contains;
}