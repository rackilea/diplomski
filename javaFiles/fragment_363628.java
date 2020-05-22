static class Node {
    public Node(double item, Node next) {
      this.item = item;
      this.next = next;
    }

    public double item;
    public Node next;
  }

  int N;
  Node first;