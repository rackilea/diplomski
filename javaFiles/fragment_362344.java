private void sortByHashcode() {
    Node<E> node = first;

    while (node != null) {
        if (last.item.hashCode() < node.item.hashCode()) {
            Node<E> tmp = last.prev;
            last.next = node;
            last.prev = node.prev;
            node.prev = last;
            if (last.prev == null) {
                first = last;
            } else {
                last.prev.next = last;
            }
            tmp.next = null;
            last = tmp;
            break;
        }

        node = node.next;
    }
}