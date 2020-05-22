public void delete(int index) {
    if (index < 0 || index > count-1) {
        throw new ArrayIndexOutOfBoundsException();
    }

    if (index == 0) {
        head = head.getLink();
    }else{
        Node<X> beforeDeletedNode = head;
        for (int i = 0; i < index-1; i++) {
            beforeDeletedNode = beforeDeletedNode.getLink();
        }
        Node<X> toDelete = beforeDeletedNode.getLink();
        beforeDeletedNode.setLink(toDelete.getLink());
    }
    count--;

}