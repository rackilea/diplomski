public class PrependLinearListImpl<T>{
    private Node first;

    private class Node {
        private T head;
        private Node tail;
        Node(T head) {
            this.head = head;
            this.tail = first;
            first = this;
        }
    }

}