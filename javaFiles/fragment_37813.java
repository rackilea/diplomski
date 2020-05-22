public class Node {
    int fele;
    Node next;

    public Node() {
        fele = 1;
        next = null;
    }

    public Node(int fele, Node next) {
        this.fele = fele;
        this.next = next;
    }

    public String toString() {
        return fele + "";
    }

    public static void main(String[] args) {
        Node node = new Node(1, null);
        System.out.println(node);
    }
}