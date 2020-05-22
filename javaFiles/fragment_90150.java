public void displaySmallToBig(Node root) {
    if (root != null) {
        displaySmallToBig(root.right);
        System.out.print(" " + root.data);
        displaySmallToBig(root.left);
    }
}