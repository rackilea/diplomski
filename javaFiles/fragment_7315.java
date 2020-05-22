public class Stack<T> {

    Node<T> top;                               // CHANGE HERE

     class Node<U> {                           // CHANGE HERE
        U value;                               // CHANGE HERE
        Node<U> next;                          // CHANGE HERE

        public Node(U value) {                 // CHANGE HERE
            this.value = value;
            next = null;
        }
    }

    public void push(T value) {
        Node<T> current = new Node<>(value);   // CHANGE HERE
        if (isEmpty())
            top = current;
        else {
            current.next = top;
            top = current;
        }
    }

    public T pop() {
        T value = null;
        if (!isEmpty()) {
            top = top.next;
            value = top.value;
        }
        return value;
    }