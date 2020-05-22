public int height(RBNode t) {
    if (t == null) {
        return 0;
    }
    return Math.max(height(t.left), height(t.right)) + 1;
}