public class Node {
    private int key;
    private Object element;
    private Node next;

    public Node(int priority, Object e, Node n){
        element = e;
        next = n;
        key = priority;
    }
    ...