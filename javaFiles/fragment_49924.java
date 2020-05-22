import java.util.*;
import static java.lang.System.out;

public class Main {
    static void printLevelOrder(Node root) {
        LinkedList<QItem> queue = new LinkedList<>();
        ArrayList<Node> level = new ArrayList<>();
        int depth = height(root);
        queue.add(new QItem(root, depth));

        for (;;) {
            QItem curr = queue.poll();

            if (curr.depth < depth) {
                depth = curr.depth;

                for (int i = (int)Math.pow(2, depth) - 1; i > 0; i--) { 
                    out.print(" ");
                }

                for (Node n : level) {
                    out.print(n == null ? " " : n.val);

                    for (int i = (int)Math.pow(2, depth + 1); i > 1; i--) {
                        out.print(" ");
                    }
                }

                out.println();
                level.clear();

                if (curr.depth <= 0) {
                    break;
                }
            }

            level.add(curr.node);

            if (curr.node == null) {
                queue.add(new QItem(null, depth - 1));
                queue.add(new QItem(null, depth - 1));
            }
            else {
                queue.add(new QItem(curr.node.left, depth - 1));
                queue.add(new QItem(curr.node.right, depth - 1));
            }
        }
    }

    static int height(Node root) {
        return root == null ? 0 : 1 + Math.max(
            height(root.left), height(root.right)
        );
    }

    public static void main(String[] args) {
        printLevelOrder(
            new Node<Integer>(
                1, 
                new Node<Integer>(
                    2, 
                    new Node<Integer>(
                        4, 
                        new Node<Integer>(7, null, null), 
                        new Node<Integer>(8, null, null)
                    ),
                    null
                ),
                new Node<Integer>(
                    3, 
                    new Node<Integer>(
                        5, 
                        new Node<Integer>(9, null, null),
                        null
                    ),
                    new Node<Integer>(
                        6,
                        null,
                        new Node<Character>('a', null, null)    
                    )
                )
            )
        );
    }
}

class Node<T> {
    Node left;
    Node right;
    T val;

    public Node(T val, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}

class QItem {
    Node node;
    int depth;

    public QItem(Node node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}