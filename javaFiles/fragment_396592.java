private ListNode head;
private ListNode tail;
public void insert(int contents) {

    ListNode newNode = new ListNode(contents);
    if (head == null) {
        head = newNode;
        tail = newNode;
        return;
    }
    tail.next = newNode;
    tail = newNode;
}