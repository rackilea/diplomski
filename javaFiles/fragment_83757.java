public class Node {
    private int key;
    private Object element;
    private Node next;

    public Node(int priority, Object e, Node n){ // priority parameter is not used
        element = e;
        next = n;
    }
    ...