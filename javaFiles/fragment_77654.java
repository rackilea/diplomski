public void switchPairs() {
    ListNode first = front;//first node in pair
    ListNode second = front.next;//second node in pair

    //while the both nodes are not null
    while(first != null && second != null) {
        int i = first.data;//put first value in temp value
        first.data = second.data;//put second value in first node
        second.data = i;//put temp value (first value) in second node

        //NOTE:  do some null pointer checks here just in case
        first = second.next;//iterate first node
        second = second.next.next;//iterate second node
    }
}