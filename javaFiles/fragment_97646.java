public List<T> kbest() {
    //empty queue first and then restore
    List<T> list = new ArrayList<T>();
    int size = heap.size();  // O(1)
    for(int i = 0; i < size; i++) { // O(n)
        list.add(0, heap.poll()); // O(n)
    }
    for(int j = 0; j < list.size(); j++){ // O(n)
        heap.add(list.get(j)); // O(log n)
    }
    return list;
}