public class Node {

  private Node left;
  private Node right;
  private Object value;

  public void inOrderPrint() {
    if (left != null)
      left.inOrderPrint();
    System.out.println(value);
    if (right != null)
      right.inOrderPrint();
  }

}