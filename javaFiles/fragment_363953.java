public class TestDoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        Integer[] intList = { 1, 3, 5, 7, 9 };
        list.add(intList);

        printState(list);

        list.addPos(3, 88);

        printState(list);
    }

    public static void printState(DoublyLinkedList<Integer> list) {
        list.printList();
        list.printReverse();
        System.out.println("Head: " + list.head);
        System.out.println("Tail: " + list.tail);
        System.out.println("Size: " + list.getSize());
        System.out.println("************************\n");
    }
}