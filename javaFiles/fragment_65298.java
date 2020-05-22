private static void printInorder(Node root) {
    if (root == null)
        return;
    printInorder(root.left);
    System.out.print(root.data + " ");
    printInorder(root.right);
}