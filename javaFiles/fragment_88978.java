public static void rearrange(Queue<Integer> q) {
    Queue<Integer> tmp = new LinkedList<>();

    // Remember size and rearrange that many items.
    int size = q.size();

    for (int count = 0; count < size; count++) {
        Integer head = q.poll();

        // Even items go on the end of the original queue, odd to temp.
        (head % 2 == 0 ? q : tmp).offer(head);
    }
    // Glue temp queue of odd values onto original which is all even.
    q.addAll(tmp);
}