public void printList() {
        Node<T> temp = head;
        do {
            System.out.print(temp.getElement() + " ");
            temp = temp.getNext();
        } while (temp != head);
    }