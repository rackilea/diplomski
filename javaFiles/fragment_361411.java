public void invert() {
        Node<E> prev = null, next = null;;
        if (head == null) return;
        while (true) {
            next = head.getNext();
            head.setNext(prev);
            prev = head;
            if (next == null) return;
            head = next;
        }
    }