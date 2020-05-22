public static void toDoublyLinked(Node node) {
    if (node.getRight() != null) {
         node.getRight().setLeft(node);
         toDoublyLinked(node.getRight());
    }
}