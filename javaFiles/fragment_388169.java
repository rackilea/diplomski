public class LinkedMovieList<M extends Comparable<M>>
implements GVLinkedList<M>, Serializable {

private class Node implements Serializable {
public M data;
public Node next;

Node(M element) {
    data = element;
    next = null;
}

}

Node head, tail;