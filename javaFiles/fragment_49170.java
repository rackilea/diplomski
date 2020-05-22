// print BST reverse Order
public static void reverseOrder(TreeNode node, int n,int i) {
    if (node == null) return;
        reverseOrder(node.right,n,i);
        if(++i<n) System.out.print(node.data);
        reverseOrder(node.left,n,i);
    }
}