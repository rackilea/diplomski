public class DoublyLinkedList<T> {

    protected Node<T> head;
    protected Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Overloaded add method for T[] list
    public void add(T[] list) {
        for(int i = 0; i < list.length; i++)
            add(list[i]);
    }

    // add method for single node
    public void add(T value) {
        if(head == null)
            head = new Node<T>(value);
        else {
            Node<T> temp = head;
            while(temp.next != null)
                temp = temp.next;

            tail = temp.next = new Node<T>(value);
            tail.prev = temp;
        }

        size++;
    }

    // add method for specific position
    // pos must be smaller/equal than the size of the list
    public void addPos(int pos, T value) {
        if(pos > size) // pos must be smaller/equal than size
            return;

        Node<T> newNode = new Node<>(value);
        size++;

        if(pos == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

            return;
        } else if(pos == size-1) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<T> temp = head;
            for(int i = 0; i < pos; i++)
                temp = temp.next;

            // insert newNode in the middle of temp.prev and temp
            // temp.prev <-> newNode <-> temp

            // attach newNode's prev and next references
            newNode.next = temp;
            newNode.prev = temp.prev;

            // attach adjacent node's references to newNode
            temp.prev.next = newNode;
            temp.prev = newNode;
        }
    }

    public static class Node<T> {

        protected T value;
        protected Node<T> prev;
        protected Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return value.toString();
        }

    }

    public void printList() {
        System.out.print("List         : ");

        if(head == null)
            System.out.printf(" <empty>\n");
        else {
            Node<T> temp = head;

            while(temp != null) {
                System.out.print(temp + " ");
                temp = temp.next;
            }
        }

        System.out.println();
    }

    public void printReverse() {
        System.out.print("List Reversed: ");

        if(head == null)
            System.out.printf(" <empty>\n");
        else {
            Node<T> temp = tail;

            while(temp != null) {
                System.out.print(temp + " ");
                temp = temp.prev;
            }
        }

        System.out.println();
    }

    public int getSize() {
        return size;
    }

}