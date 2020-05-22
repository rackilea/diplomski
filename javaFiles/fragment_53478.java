public class LiOl {
  static StringBuilder sb = new StringBuilder();

  static void printList(List<Node> l) {
    if (l == null || l.size() == 0) {
      return;
    }
    sb.append("<ol>");
    for (Node n : l) {
      printNode(n);
    }
    sb.append("</ol>");
  }

  static void printNode(Node n) {
    sb.append("<li>").append(n.name).append("</li>");

    sb.append("<li>");
    printList(n.children);
    sb.append("</li>");
  }

  public static void main(String[] args) {
    List<Node> l = null;
    printList(l);

    sb.toString();
  }
}

class Node {
  String name;
  List<Node> children;
}