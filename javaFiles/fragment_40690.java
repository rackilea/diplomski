private Node deleteKey(Node n, int data) {

    if (n == null) return n;

    if (data < n.data)
        n.left = deleteKey(n.left, data); // must reassign child here
    else if (data > n.data)
        n.right = deleteKey(n.right, data); // must reassign child here
    else {
        if (n.left == null) return n.right;
        else if (n.right == null) return n.left;

        n.data = findMin(n.right).data;
        n.right = deleteKey(n.right, n.data); // this was correct
    }
    return n;
}