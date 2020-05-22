class LinkedList<E> {
    // reference to the head node.
    private Node head;
    private int listCount;

    public boolean delete(E string)
    // post: removes the element at the specified position in this list.
    {
        Node current = head;

        while (true) {
            if (current == null) {
                return false;
            } else if (current.getData().equals(string)) {
                if (current.getNext() == null) {
                    current.setNext(null);
                } else {
                    current.setNext(current.getNext().getNext());
                }
                listCount--; // decrement the number of elements variable
                return true;
            } else {
                current = current.getNext();
            }
        }
    }

    private class Node {
        // reference to the next node in the chain,
        Node next;
        // data carried by this node.
        // could be of any type you need.
        E data;

        // Node constructor
        public Node(E _data) {
            next = null;
            data = _data;
        }

        // another Node constructor if we want to
        // specify the node to point to.
        public Node(E _data, Node _next) {
            next = _next;
            data = _data;
        }

        // these methods should be self-explanatory
        public E getData() {
            return data;
        }

        public void setData(E _data) {
            data = _data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node _next) {
            next = _next;
        }
    }

}