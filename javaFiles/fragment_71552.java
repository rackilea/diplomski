PriorityQueue<edge> pr = new PriorityQueue<edge>(ar, comp) {
    PriorityQueue(List<edge> ar, Comparator<edge> c) {
        this(c);
        for(int i = 0; i < queue.length; i++) {
            queue[i] = ar.get(i);
        }
        this.size = queue.length;
        heapify(); // O(n), except that heapify is private and thus you can't call it!!!
    }
}