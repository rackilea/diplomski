public Node max(Node node1, Node node2) {
    if (node1 == null || node2 == null)
        return node1;
    else
        return max(node1.getKey() > node2.getKey() ? node1 : node2, node2.getNext());
}