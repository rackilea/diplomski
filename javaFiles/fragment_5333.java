public class BinaryTree {
    char[] tree = {'k', 'q', 'r', 'g', 'e', 'i', 'y', 'p', 'l', 'b', 'x', 'm', 'g', 't', 'u', 'v', 'z'};
    public void inorder(int node) {
        if(node < tree.length) {
            inorder((node * 2) + 1);
            System.out.print(tree[node] + " ");
            inorder(((node * 2) + 2));
        }
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.inorder(0);
    }
}