public void count(T x) {
    if(heap.size() < k){ // O(1)
        heap.add(x); // O(log k)
    }
    else if(heap.size() == k && // O(1)
                x.compareTo(
                    (T) heap.peek()) > 0) { // O(1)
        heap.remove(); // O(log k)
        heap.add(x); // O(log k)
    }
}