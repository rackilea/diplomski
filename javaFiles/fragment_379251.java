Node current = head, prev = null;
    while (current != null) {
        if (current.getData().equals(string)) {
            // Remove current from list
            if (current == head) {
                head = current.getNext();
            } else {
                prev.setNext(current.getNext());
            }

            listCount--; // decrement the number of elements variable
            return true;
        }
        prev = current;
        current = current.getNext();
    }