public class DoublyLinkedList {
    ...
    DoublyLinkedList prepend(String info) {
        // Beginning of a list, insert new element
        if (prev == null) {
            // this is the changed line.
            prev = new DoublyLinkedList(info, null, this);
        } else {
            prev.prepend(info);
        }
        return prev;
    }
}