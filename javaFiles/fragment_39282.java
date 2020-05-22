public void add(int value) {
    if(first == null) {
        first = new Node(value, null);
        first.setNext(first);
    } else {
        // Remember the current first
        Node oldFirst = first;
        // Make a copy of the first node the "new first"
        first = new Node(first.getValue(), first.getNext());
        // Copy the new value into the "old first",
        // and make its next point to the "new first"
        oldFirst.setValue(value);
        oldFirst.setNext(first);
    }
    System.out.println("Added: " + value);
    size++;
}