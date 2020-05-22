public class BST<T implements Comparable<T>> {
    private final Node<T> root;

    /** Presumably this is run when a value is added.. */
    private void addValueHelper(Node rootNode, Node newNode) {
        rootNode.attachChild(newNode);
    }

    public static class Node implements Comparable<T> {
        private final T val;
        private Node left;
        private Node right;

        public Node(T val) {
            this.val = val;
        }

        public int compareTo(Node other) {
            return this.val.compareTo(other.val);
        }

        /**
         * Takes the given node and compares it with the current node.
         * If the current node is greater than the given node, the given node is placed to the left.
         * Otherwise it is placed to the right.
         */
        protected void attachChild(Node newNode) {
            if (this.compareTo(newNode) == 1) {
                if (this.left == null) {
                    this.left = newNode;
                    return;
                }
                this.left.attachChild(newNode);
                return;
            } 

            if (this.right == null) {
                this.right = newNode;
                return;
            }

            this.right.attachChild(newNode);
        }
    }
}