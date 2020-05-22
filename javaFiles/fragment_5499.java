public int getVal() {
    return val;
}


PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length,
        (l1, l2) -> l1.getVal() < l2.getVal() ? -1 :
                    l1.getVal() == l2.getVal() ? 0 :
                    1);