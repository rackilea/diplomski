public class LinkedList {
    public static class Node {
        private Object data;
        private Node next = null;

        public Node(Object data) {
            this.data = data;
        }

        public void setNext(Node n) {
            next = n;
        }

        public Node getNext() {
            return next;
        }

        public Object getData() {
            return data;
        }
    }

    public static void iterate(Node n) {
        while (n != null) {
            System.out.println(n.getData());
            n = n.getNext();
        }
    }

    public static void insert(Node newNode, Node after) {
        newNode.setNext(after.getNext());
        after.setNext(newNode);
    }

    public static void delete(Node toDelete, Node root) {
        Node n = root;
        while (n.getNext() != toDelete) {
            n = n.getNext();
        }
        n.setNext(toDelete.getNext());
    }

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");

        // append
        a.setNext(b);
        b.setNext(c);

        // iterate
        System.out.println("Initial list");
        iterate(a);

        // insert d after b
        Node d = new Node("d");
        insert(d, b);

        // iterate again
        System.out.println("After insert");
        iterate(a);

        // delete d
        delete(d, a);

        // iterate again
        System.out.println("After delete");
        iterate(a);
    }
}