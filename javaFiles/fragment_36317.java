public static int findValue(ListNode x, int valueToCount) {
    ListNode currentNode = x;
    int count = 0;
    while (currentNode.next!=null) {
      if (currentNode.value == valueToCount) {
        count++;
      }
      currentNode = currentNode.next;
    }
    return count;
}