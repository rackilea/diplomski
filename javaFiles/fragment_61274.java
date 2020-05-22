public final class TestList<E> {
    private Node<E> head;
    private Node<E> tail;

    public void addLast(E data) {
        Node<E> node = new Node<>(data);

        if (head == null)
            head = tail = node;
        else if (head == tail) {
            tail = node;
            head.next = tail;
            tail.prev = head;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void removeLast() {
        if (tail == null)
            System.err.println("List is empty!");
        else if (head == tail)
            head = tail = null;
        else {
            Node<E> prev = tail.prev;
            tail.prev = null;
            tail = null;
            tail = prev;
            tail.next = null;
        }
    }

    private static final class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data) {
            this.data = data;
        }
    }
}