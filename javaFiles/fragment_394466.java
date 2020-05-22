static class LinkedList<T> {
    private class Node {
        private final T value;
        private Node next = null;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node head = null;

    public void add(T value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    public void remove(T value) {
        while (head != null && head.value.equals(value))
            head = head.next;
        Node prev = head;
        while (prev != null && prev.next != null) {
            if (prev.next.value.equals(value))
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
    }
}