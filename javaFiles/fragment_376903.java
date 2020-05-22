public void printOut(AVLNode root)
{
  System.out.print("(");
  if (root != null) {
    System.out.print(root.number);
    printOut(root.left);
    printOut(root.right);
  }
  System.out.print(")");
}