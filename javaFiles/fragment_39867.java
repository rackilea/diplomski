// This will compile
public class DoublyLinkedList<Item> {

    public static <T> void insertStart(DoublyLinkedList<T> list, DoubleNode<T> first) {
        // implementation
    }

    private static class DoubleNode<E> {
        E item;
        DoubleNode<E> next;
        DoubleNode<E> previous;

    }
}