public static void toDoublyLinked(Node node) {
    Node current = node;
    while (current.getRight() != null) {
        current.getRight().setLeft(current);
        current = current.getRight();
    }
}