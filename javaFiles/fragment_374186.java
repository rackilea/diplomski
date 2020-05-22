public static <E> void printReverse(final SinglyLinkedList<E> list) {
    if(list.getLength() > 0) {
        System.out.println(list.remove(list.getLength()-1));
        printReverse(list);
    }
}