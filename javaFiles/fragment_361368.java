public static BinaryTreeNode findLCA( BinaryTreeNode root, BinaryTreeNode node1 , BinaryTreeNode node2) {       

    if (root == null) {
        return null;
    }       

    BinaryTreeNode left = root.getLeft();
    BinaryTreeNode right = root.getRight();
    BinaryTreeNode lcaNode1;
    BinaryTreeNode lcaNode2;

    if (left != null && (left == node1 || left == node2)) {
        return root;                
    }

    if (right != null && (right == node1 || right == node2)) {
        return root;                
    }
    lcaNode1 =  findLCA(left, node1, node2);
    lcaNode2 =  findLCA(right, node1, node2);

    if (( lcaNode1 != null) && lcaNode2 != null) {          
        return root;
    }

    if (lcaNode1 != null) {
        return lcaNode1;
    }

    if (lcaNode2 != null) {
        return lcaNode2;
    }       

    return null;        
}