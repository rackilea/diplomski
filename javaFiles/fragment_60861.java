//Deleting node from LinkedList

public static Node1 delete2(Node1 head, int d) {
    if (head.data == d) {
        // Delete head node
        return head.Next;
    }
    Node1 start = head;

    while (start.Next != null) {
        if (start.Next.data == d) {
            // Delete the next node
            start.Next = start.Next.Next;
            break;
        }
        start = start.Next;
    }
    return head;
}

public static Node1 delete(Node1 head, int d) {

    Node1 start = head;

    while (start.data != d) {

        start = start.Next;

    }

    while (start.Next != null) {

        start.data = start.Next.data;

        start = start.Next;

    }

    start = null;

    return head;

}