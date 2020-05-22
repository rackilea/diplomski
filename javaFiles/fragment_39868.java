// Source : Oracle JDK 1.7.0_67 lib - inside LinkedList class
private static class Node<E> {
     E item;
     Node<E> next;
     Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
       this.item = element;
       this.next = next;
       this.prev = prev;
    }
}