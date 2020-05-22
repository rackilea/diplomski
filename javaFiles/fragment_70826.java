import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Blacklist {
    private final Node root = new Node(Integer.MIN_VALUE, false);

    public synchronized void add(int[] array) {
        if (array == null) return;
        Node next, cur = root;

        for(int i = 0; i < array.length-1 && !cur.isLeaf(); i++) {
            next = cur.getChild(array[i]);

            if (next == null) { 
                next = new Node(array[i], false);
                cur.addChild(next);
            }

            cur = next;
        }

        if (!cur.isLeaf()) {
            next = cur.getChild(array[array.length-1]); 
            if (next == null || !next.isLeaf())
                cur.addChild(new Node(array[array.length-1], true));
        }
    }

    public synchronized boolean contains(int[] array) {
        if (array == null) return false;
        Node cur = root;

        for (int i = 0; i < array.length; i++) {
            cur = cur.getChild(array[i]);
            if (cur == null) return false;
            if (cur.isLeaf()) return true;
        }

        return false;
    }

    private static class Node {
        private final Map<Integer, Node> children; 
        private final int value;

        public Node(int _value, boolean leaf) { 
            children = (leaf?null:new HashMap<Integer, Node>());
            value = _value;
        }

        public void addChild(Node child) { children.put(child.value, child); }
        public Node getChild(int value) { return children.get(value); }
        public boolean isLeaf() { return (children == null); }

    }
}