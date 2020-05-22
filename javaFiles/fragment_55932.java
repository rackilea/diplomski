public class CustomLinkedList<T>  implements Iterable<T>{
    private class Node {/**/}

    private class Iterator implements ListIterator<T> {
        Node next, previous;

        Iterator() {
            next = root;
            previous = null; 
        }

        public boolean hasNext() {
            return next != null;
        }

        public T next() {
            if ( ! hasNext()){
                throw new NoSuchElementException();
            }
            previous = next;
            next = next.getNext();
            return previous;
        }

        public boolean hasPrevious() {
            return previous != null;
        }

        public T previous() {
            if ( ! hasPrevious() ){
                throw new NoSuchElementException();
            }
            next = next.getPrevious();
            previous = next.getPrevious();
            return next;
        }
    }

    Node root;
    int size;

    //Object methods, and some basic Collection methods
}