public class MyTree<E> implements MyTreeI<E> {
    private Node<E> root;      // root of tree


    private static class Node<E> {
        private E val;
        private Node<E>[] children = (Node<E>[])new Node<?>[2];
    }

    public MyTree() {
    }


    @Override
    public E get(String key) {
        Node<E> x = getNode(key); // helper function, assume it returns node in question
        return x.val;
    }
}