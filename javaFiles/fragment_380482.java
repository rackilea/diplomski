public class DoublyLinkedList<T> implements Collection<T> {

    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    public class DoublyLinkedNode {
        private DoublyLinkedNode prev;
        private DoublyLinkedNode next;
        T element;
    }

    public class DoublyLinkedListIterator implements ListIterator<T> {
        private DoublyLinkedNode current = head;
    }
}