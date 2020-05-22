boolean check(Node root) {
    return check(root, INT_MIN, INT_MAX);
}
boolean check(Node n, int minval, int maxval) {
    if (n == null) {
        return true;
    }
    return (
        n.data >= minval && n.data <= maxval &&
        check(n.left, minval, n.data-1) &&
        check(n.right, n.data+1, maxval)
    );
}