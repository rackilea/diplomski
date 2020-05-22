public class CircularLinkedList<T> {
    private class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> previous;

        public Node(T element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        // getters and setters
    }
    private Node<T> head;

    public CircularLinkedList(){
        head = null;
    }
}