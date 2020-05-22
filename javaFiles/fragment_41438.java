import java.util.Iterator;
import java.util.NoSuchElementException;

public class Node implements Iterable<Node> {

    class NodeIterator implements Iterator<Node> {

        private Node node;

        public NodeIterator(Node node) {
            this.node = node;
        }

        public boolean hasNext() {
            return node != null;
        }

        public Node next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Node rtn = node;
            node = node.next;
            return rtn;
        }

    }

    private int value;

    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator(this);
    }

    public static void main(String[] args) {
        Node node4 = new Node(1, null);
        Node node3 = new Node(1, node4);
        Node node2 = new Node(1, node3);
        Node node1 = new Node(1, node2);
        int sum = 0;
        for (Node node : node1) {
            sum += node.value;
        }
        System.out.println(sum);
    }
}