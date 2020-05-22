public static IntNode method(IntNode head1, IntNode head2)
{

    List<Integer> sort = new ArrayList<>();

    for (IntNode n = head1; n != null; n = n.link) {
        sort.add(n.data);
    }
    for (IntNode n = head2; n != null; n = n.link) {
        sort.add(n.data);
    }

    Collections.sort(sort);

    // run though sorted list, removing adjacent duplicates
    for (int i = 0; i < sort.size(); ++i) {
        if (i > 0 && sort.get(i) == sort.get(i - 1)) {
            sort.remove(i);
        }
    }

    // Now put the sorted, unduplicated numbers into a new list of IntNodes
    IntNode new_head = null;
    for (int data : sort) {
        IntNode newNode = new IntNode(data, null);
        new_head = insertNode(new_head, newNode);
    }
    return new_head;
}