private class Node<NodeKey extends Comparable<NodeKey>, NodeValue> {
    private NodeKey key;           // sorted by key
    private NodeValue val;         // associated data
    private Node<NodeKey, NodeValue> left, right;  // left and right subtrees
    private int N;             // number of nodes in subtree

    public Node(NodeKey key, NodeValue val, int N) {
        this.key = key;
        this.val = val;
        this.N = N;
    }
}