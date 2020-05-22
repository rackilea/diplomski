class Node {
    public Node copy() {
        Node copy = new Node(data);
        if (next != null)
            copy.next = next.copy();
        return copy;
    }
}