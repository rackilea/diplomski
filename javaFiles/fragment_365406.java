class Node
{
  String val;

  Node next, prev;

  public Node getNext() {
    return next;
}

public void setNext(Node next) {
    this.next = next;
}

public Node getPrev() {
    return prev;
}

public void setPrev(Node prev) {
    this.prev = prev;
}

public Node(String v)
  {
      val=v;
  }