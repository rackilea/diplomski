public class A {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList<Integer>();
        list.addFirst(new Integer(1));
        list.addLast(new Integer(2));
        System.out.println(list.first());
        System.out.println(list.last());
    }
}