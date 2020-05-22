class DoublyLinkedStringList {

private Node head, tail;
boolean forward;

/**
 * Diese Klasse repraesentiert einen Knoten in der Doubly Linked List der
 * Klasse
 * <code>DoublyLinkedStringList</code>
 *
 */
private class Node {
    private String content;
    private Node next;
    private Node prev;

    public Node(String content) { this.content = content; }

    public Node(String content, Node next) {
        this.content = content;
        if(forward) { this.next = next; }                     //EDITED
        else        { this.prev = next; }                     //EDITED
    }

    public Node getNext() { return (forward) ? next : prev; } //EDITED
    public Node getPrev() { return (forward) ? prev : next; } //EDITED

    public void setNext(Node next) {
        if(forward) { this.next = next; }                     //EDITED
        else        { this.prev = next; }                     //EDITED
    }

    public void setPrev(Node prev) {
        if(forward) { this.prev = prev; }                     //EDITED
        else        { this.next = prev; }                     //EDITED
    }
}

public DoublyLinkedStringList() {
    this.head = null;
    this.tail = null;
}

public Node prepend(String info) {
    Node newNode = new Node(info);
    newNode.setPrev(null);
    newNode.setNext(getHead());
    if(newNode.getNext()!=null) { 
      newNode.getNext().setPrev(newNode);                     //EDITED
    } 
    if(forward) { head = newNode; }                           //EDITED
    else        { tail = newNode; }                           //EDITED
    if(getTail() == null) {                                   //EDITED
      if(forward) { tail = newNode; }                         //EDITED
      else        { head = newNode; }                         //EDITED
    }
    return head;
}

public Node delete(int index) {
    Node currNode = getHead();
    int count = 0;

    if (index == 0) {
        if(forward) { head = head.next; }                     //EDITED
        else        { tail = tail.prev; }                     //EDITED
        return head;
    }

    while (currNode != null) {
        if (count + 1 == index) {
            currNode.next.prev = currNode.prev; 
            currNode.prev.next = currNode.next;               //EDITED
            break;
        }
        currNode = currNode.getNext();                        //EDITED
        count++;
    }
    return currNode;
}

private Node next() {
    Node currNode = head;

    if (forward) {
        return currNode.getNext();
    } else {
        return currNode.getPrev();
    }
}

public Node getHead() { return (forward) ? head : tail; }     //EDITED
public Node getTail() { return (forward) ? tail : head; }     //EDITED
public DoublyLinkedStringList reverse() { forward = !forward; return this; }

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    //EDITED LOOP STRUCTURE
    for (Node currNode = getHead(); currNode != null; currNode = currNode.getNext()) {
        sb.append(currNode.content);
        if (currNode.getNext() != null) {
            sb.append(", ");
        }
    }
    return sb.toString();
}

public static void main(String argv[]) {
    DoublyLinkedStringList list = new DoublyLinkedStringList();
    list.prepend("6");
    list.prepend("5");
    list.prepend("4");
    list.prepend("3");
    list.prepend("2");
    list.prepend("1");
    list.prepend("0");
    list.delete(3);
    System.out.println(list);
    System.out.println(list.reverse());
}
}