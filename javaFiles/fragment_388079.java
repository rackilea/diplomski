/**
 * @return false if the recursion has been aborted
 */
public boolean createTree(TreeNode tree) throws IOException {
    if (i >= preorder.length) {
        return false;
    } 
    else if (preorder[i] == '0') {
        tree.value = '0';
        tree.left = tree.right = null;
        i++;                
    } 
    else {
        tree.value = preorder[i];
        i++;
        tree.left = new TreeNode();
        if (!createTree(tree.left)) {
            return false;
        };
        tree.right = new TreeNode();
        if (!createTree(tree.right)) {
            return false;
        }
    }
}