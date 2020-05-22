public static void main(String[] args) {
    List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    int m = values.size(), n = 4;

    Node[] nodes = initializeGraph(values, m, n);

    Node current = nodes[0];
    for (int i = 0; i < m - 1; i++) {
        Node out = current.out;
        out.remove();
        current = out.right;
    }
    System.out.println(current.value);
}

private static Node[] initializeGraph(List<Integer> values, int m, int n) {
    Node[] nodes = new Node[m];

    for (int i = 0; i < m; i++) nodes[i] = new Node(values.get(i));
    for (int i = 0; i < m; i++) {
        Node current = nodes[i];

        current.right = nodes[(i + 1) % m];
        current.left = nodes[(m + i - 1) % m];
        Node next = nodes[(i + n) % m];

        current.out = next;
        next.addIn(current);
    }

    return nodes;
}

private static class Node {
    private final int value;
    private final Set<Node> in = new HashSet<>();

    private Node out;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public void addIn(Node node) {
        in.add(node);
    }

    public void remove() {
        left.right = right;
        right.left = left;

        for (Node node : in) {
            node.out = right;
            right.addIn(node);
        }

        out.in.remove(this);
    }
}