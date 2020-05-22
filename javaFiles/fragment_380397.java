static class Node {
    final Node next;
    final Object o;
    Node(Node next, Object o) {...}
}

final Node start, end;

private Queue(Node start, Node end) {...}

public Queue(Object o) {
    start = end = new Node(null, o);
}

public Queue add(Object o) {
    return new Queue(start, new Node(end, o));
}

public Queue remove() {
    return new Queue(start, end.next);
}