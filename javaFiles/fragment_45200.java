public boolean contains(int val){
    return containsHelper(val, root);
}
public boolean containsHelper(int val, Node root){
    if(root == null) return false;

    if(root.val == val) return true;
    else if (root.val < val) {
        return containsHelper(val, root.right);
    }else {
        return containsHelper(val, root.left);
    }
}