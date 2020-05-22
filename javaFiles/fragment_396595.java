public void print() {
    ListNode cursor = head;
    while (cursor != null) {
        System.out.println(cursor.contents);
        cursor = cursor.next;
    }
}