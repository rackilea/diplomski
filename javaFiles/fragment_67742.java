/** Search value in Tree need for Successor **/
public TreeNode search(int key) {
    TreeNode node = root;
    while (node != null 
            && key != node.value) {

        if(key < node.value) {
            node = node.left;
        } else if (key > node.value) {
            node = node.right;
        }
    }
    return node;
}

/** Returns Successor of given value **/
public int getSuccessor(int val) {
    TreeNode node; 
    if (null == (node = search(val))
            || (null == (node = successor(node))) {
        // either val is not in BST, or it is the last value-> no successor
        return ERROR_CODE; // -1, for instance;
    }

    return node.value;
}