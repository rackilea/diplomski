public class HashMapTest {

static class Node {
  Integer n;

  public Node(int n) {
    this.n = n;
  }

  @Override
  public int hashCode() {
    return n%3;
  }

  @Override
  public boolean equals(Object object) {
    Node node = (Node)object;
    return this.n.equals(node.n);
  }

  @Override
  public String toString() {
    return n.toString();
  }
}

  public static void main(String[] args) {
    Map<Node, String> map = new HashMap<>();
    for (int i = 0; i<6; i++) {
      map.put(new Node(i), ""+i);   // <-- Debug Point
    }
    map.put(new Node(0), "xxx");
  }                                 // <-- Debug Point
}