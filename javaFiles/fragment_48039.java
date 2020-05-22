public class RecursiveCopyTest {
    public static void main(String[] args) {
        final LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("first");
        linkedList.add("next");
        linkedList.add("last");
        System.out.println(linkedList);
        System.out.println(linkedList.copyRecursive());
        System.out.println(linkedList.reverse());
   }

private static class LinkedList<E> {

    private Node<E> first;

    public LinkedList() {
        first = null;
    }

    public LinkedList<E> copyRecursive() {
        return copyRecursive(first, new LinkedList<E>());
    }

    public LinkedList<E> reverse() {
        return reverse(first);
    }

    public void add(E element) {
        final Node<E> node = new Node<>(element);
        if (first == null) {
            first = node;
        } else {
            Node<E> current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }

    }

    private LinkedList<E> reverse(final Node<E> node) {
        if (node == null) {
            return new LinkedList<>();
        }
        final LinkedList<E> accumulator = reverse(node.getNext());
        accumulator.add(node.getElement());
        return accumulator;
    }

    private LinkedList<E> copyRecursive(final Node<E> node, final LinkedList<E> accumulator) {
            if (node == null) {
                return accumulator;
            }
            accumulator.add(node.getElement());
            return copyRecursive(node.getNext(), accumulator);
        }

        @Override
        public String toString() {
            final StringBuilder stringBuilder = new StringBuilder();
            Node current = first;
            while (current != null) {
                stringBuilder.append(current.getElement().toString()).
                        append(" -> ");
                current = current.getNext();
            }
            stringBuilder.append(" _ ");
            return stringBuilder.toString();
        }

        private static final class Node<E> {
            private final E element;
            private Node<E> next;

            public Node(final E element) {
                this.element = element;
            }

            public E getElement() {
                return element;
            }

            public void setNext(final Node<E> next) {
                this.next = next;
            }

            public Node<E> getNext() {
                return next;
            }
        }
    }
}