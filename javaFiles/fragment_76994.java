public void printReverseList() {
        Node<T> temp = head;
        do {
            System.out.print(temp.getElement() + " ");
            temp = temp.getPrevious();
        } while (temp != head);
    }