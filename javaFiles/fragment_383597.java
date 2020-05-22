if (current.getLeft() == null) {
    ...
}
else {
    current = current.getLeft();
    if (current.isLeaf()) {
        result += current.getWeight().getLetter();
        current = root;
    }
}