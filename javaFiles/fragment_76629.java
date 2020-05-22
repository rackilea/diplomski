public class LinkedListStack {
    private Node top = null;

    public LinkedListStack() {
    }

    public void push(final String item) {
        top = new Node(item, top);
    }

    public void printList() {
        Node currentNode = top;
        for (currentNode = top; currentNode != null; currentNode = currentNode.getNext()) {
            System.out.println(currentNode.getItem());
        }
    }

    public class Node {
        private String item;
        private Node next;

        public Node(final String newItem, final Node nextNode) {
            item = newItem;
            next = nextNode;
        }

        public Node(final String newItem) {
            item = newItem;
            next = null;
        }

        // to set the value of the next field
        public void setNext(final Node nextNode) {
            next = nextNode;
        }

        // read the value of the next field
        public Node getNext() {
            return next;
        }

        // to set the value of the item field
        public String setItem(final String newItem) {
            item = newItem;
            return item;
        }

        // read the value of the item field
        public String getItem() {
            return item;
        }
    }

    public static void main(final String args[]) {
        final LinkedListStack newList = new LinkedListStack();
        newList.push("hello");
        newList.push("goodbye");
        newList.printList();
    }
}