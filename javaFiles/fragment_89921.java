@Override
public Iterator<Node> iterator() {

    Node current = head;

    Iterator<Node> iterator = new Iterator<>() {
        @Override
        public boolean hasNext() {
            return current!= null;
        }

        @Override
        public T next() {
            Node currentNode = current;
            current = current.next;
            return currentNode;
        }
    };
    return iterator;
}