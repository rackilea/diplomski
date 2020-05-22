public List<E> toList() {
    List<E> result = new ArrayList<E>();
    treeToList(root, result);
    return result;
}

private void treeToList(Node<E> node, List<E> goal) {
    if (node != null) {
        treeToList(node.left, goal);
        goal.add(node.value);
        treeToList(node.right, goal);
    }
}