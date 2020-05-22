public T getMin() {
    Node<T> temp = head.getNext();
    T min = head.getData();
    while(temp != null) {
        T candidateValue = temp.getData();
        if (candidateValue.compareTo(min) < 0) { // equivalent to candidate < min
            min = candidateValue;
        }
        temp = temp.getNext();
    }
    return min;
}