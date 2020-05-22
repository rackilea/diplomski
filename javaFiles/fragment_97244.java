public class Node<T,V> {
    T type;
    V value;
    Node<T,V> left, right;
}

// ...

private static final int INDENT_WIDTH = 4;
// ...

public void printParseTree(Node root) {
    preOrder(root, 0);
}

private void preOrder(Node root, int depth){
    if (root != null) {
        for (int i = 0; i < depth * INDENT_WIDTH; ++i) {
            System.out.print(" ");
        }
        System.out.println(root.value.toString() + ":" + root.type.toString());
        preOrder(root.left, depth+1);
        preOrder(root.right, depth+1);
    }
}