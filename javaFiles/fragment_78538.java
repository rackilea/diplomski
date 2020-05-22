public int depthSearch(Node root, int key) {

    if (root == null || root.data == key) {
        return 1;
    }    
    else if (root.data > key) {
        return 1 + depthSearch(root.left, key);
    } else {
        return 1 + depthSearch(root.right, key);
    }
}