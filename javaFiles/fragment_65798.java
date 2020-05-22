public static Node readTree(Scanner in) {
    Queue<Node> queue = new LinkedList<Node>();
    Node root = new Node(1);
    queue.add(root);
    while (!queue.isEmpty()) {
        Node node = queue.poll();
        int left = in.nextInt();
        int right = in.nextInt();
        if (-1 != left) {
            node.left = new Node(left);
            queue.add(node.left);
        }
        if (-1 != right) {
            node.right = new Node(right);
            queue.add(node.right);
        }
    }
    return root;
}

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    in.nextInt(); // number of nodes is not used.
    Node result = readTree(in);
}