public static void main (String[] args) {
    // Notice the list declaration where T becomes an actual data type.
    CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();

    list.addToHead(1);
    list.printList();
    System.out.println();
    list.printReverseList();
    System.out.println();

    list.addToHead(2);
    list.addToHead(3);
    list.printList();
    System.out.println();
    list.printReverseList();
}