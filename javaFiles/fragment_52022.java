private BinaryNode pruneLeaves (BinaryNode p) {

    // There is a left child
    if (p.left != null)
        if (isLeaf(p.left)) //Is that child a leaf?
            p.left = null;             
        else
            pruneLeaves(p.left);      // If it is not, recursive call

    // Is there a right child
    if (p.right != null)
        if (isLeaf(p.right))
            p.right = null;            
        else
            pruneLeaves(p.right);     // Recursive call
    return p;
}

// Main recursive call, passes the root of calling tree to the helper method
public void pruneLeaves () {
    pruneLeaves (this.getRoot());
}

// Returns true if child is a leaf
boolean isLeaf (BinaryNode t) {
    if (t.left == null && t.right == null) {
        return true;
    }
    return false;
}