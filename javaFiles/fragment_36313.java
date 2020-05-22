import java.util.ArrayList;
import java.util.List;

public class ListHierarchy {

    static class Node{
        private Node parent;
        private int value;
        private List<Node> children;

        public Node(int value, Node parent){
            this.value = value;
            this.parent = parent;
            this.children = new ArrayList<>();
            if(parent!=null && parent.children.contains(this)==false) {
                parent.children.add(this);
            }
        }

        public int value() {
            return value;
        }

        public Node parent() {
            return parent;
        }

        public List<Node> children() {
            return children;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Node)){
                return false;
            }
            Node that = (Node) obj;
            return this.value == that.value && this.parent == that.parent;
        }
    }

    public static void main(String[] args) {

        /*
         *Parent    Child
         * null      101
         * 101       103
         * 101       104
         * 103       105
         * 103       106
         * 104       107
         */

        List<Node> nodes = new ArrayList<>();
        Node n = new Node(101, null); // null parent means root node
        Node n1 = new Node(103, n);
        Node n2 = new Node(104, n);
        Node n3 = new Node(105, n1);
        Node n4 = new Node(106, n1);
        Node n5 = new Node(107, n2);

        nodes.add(n);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);

        List<Node> ordered = new ArrayList<>();
        walk(n, ordered);

        System.out.println(ordered);
    }

    /**
     * Using DFS to walk through the Nodes
     * @param root - Root node from which to start DFS.
     * @param ordered - New Empty List to add nodes to.
     */
    public static void walk(Node root, List<Node> ordered) {
        ordered.add(root);
        for(Node child: root.children()) {
            walk(child, ordered);
        }
    }

}