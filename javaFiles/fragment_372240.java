class BinaryTree {

    public Node root;

    public BinaryTree copyTree(Node focusNode) {
        BinaryTree bt = new BinaryTree();
        bt.root = preOrderCopy(focusNode);
        return bt;
    }

    public static void preOrderPrint(BinaryTree t) {
        preOrderPrint(t.root);
    }

    public static void preOrderPrint(Node n) {
        if (n == null) {
            // base case
            return;
        }
        System.out.println(n);
        preOrderPrint(n.leftChild);
        preOrderPrint(n.rightChild);

    }

    private Node preOrderCopy(Node focusNode) {
        if (focusNode == null) {
            // base case
            return null;
        }
        Node copy = new Node(focusNode.key, focusNode.name);
        copy.leftChild = preOrderCopy(focusNode.leftChild);
        copy.rightChild = preOrderCopy(focusNode.rightChild);
        return copy;
    }

}