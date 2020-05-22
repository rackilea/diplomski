class Node {

    BinaryTree left, right;
    Integer data;

    Node(Integer d, BinaryTree left, BinaryTree right) {
        this.data  = d;
        this.left  = left;
        this.right = right;
    }
} 

class BinaryTree {

    Node root;

    // Empty tree
    BinaryTree() {
        this(null);
    }

    BinaryTree(Node root) {
        this.root == root;
    }

    void insert(int d) {

        if (this.root == null) {

            // The tree was empty, so it creates a new root with empty subtrees
            this.root = new Node(d, new BinaryTree(), new BinaryTree());

        } else if (d > this.root.data) {
            this.root.right.insert(d);
        } else if (d < this.root.data) {
            this.root.left.insert(d);
        }
    }
}