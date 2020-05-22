public static void inOrder(TreeNode node) {
    if(node != null)
    {
      inOrder(node.getLeft());
      System.out.println(node.getData() + " ");
      inOrder(node.getRight());
    }
  }

  public static void inOrder(UBT root) {
    if (root.getRoot() != null) {
      inOrder(root.getRoot());
    }
  }