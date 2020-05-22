/* inserts x into the beginning of the list */
public void insertFront(int x)
{
    // Temporarily memorize previous head
    ListNode previousHead = this.head;

    // Create the new head element
    ListNode nextHead = new ListNode();
    nextHead.data = x;
    // Let it point to the previous element which is now the second element
    nextHead.next = previousHead;

    // Update the head reference to the new head
    this.head = nextHead;
}