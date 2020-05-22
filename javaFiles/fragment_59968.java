if(root != null) {
    if(root.data > 0) {
        root.data = 2 * root.data;
    }
    doublePositives(root.left);
    doublePositives(root.right);
}