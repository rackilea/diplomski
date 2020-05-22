public T getMin(Comparator<? super T> comparator) {
    Node<T> temp = head.getNext();
    T min = head.getData();
    while(temp != null) {
        T candidateValue = temp.getData();
        if (comparator.compare(candidateValue, min) < 0) { // equivalent to candidate < min
            min = candidateValue;
        }
        temp = temp.getNext();
    }
    return min;
}