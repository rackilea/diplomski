import java.util.*;

class NaryTree {
    final int data;
    final List<NaryTree> children;

    public NaryTree(int data, NaryTree... children) {
        this.data = data;
        this.children = Arrays.asList(children);
    }

    static class InOrderIterator implements Iterator<Integer> {
        final Queue<NaryTree> queue = new LinkedList<NaryTree>();

        public InOrderIterator(NaryTree tree) {
            queue.add(tree);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Integer next() {
            NaryTree node = queue.remove();
            queue.addAll(node.children);
            return node.data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    Iterable<Integer> inOrderView = new Iterable<Integer>() {
        @Override
        public Iterator<Integer> iterator() {
            return new InOrderIterator(NaryTree.this);
        } 
    };
}