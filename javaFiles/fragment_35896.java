public class MyList {
    private Node head;

    public Node getHeadNode() {
        return this.head;
    }
    public class Node {
        private int data;
        private Node next;
        //constructor
        public Node(int data) { this.data = data; this.next = null; }
    }
}