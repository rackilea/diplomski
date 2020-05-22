public void removeAllOccurrences(T targetElement) throws ElementNotFoundException {
    removeElement(targetElement);

    Comparable<T> comparableElement = (Comparable<T>) targetElement;
    Iterator<T> iter = iteratorInOrder();
    int n = 0;

    while(iter.hasNext()) {
        if (comparableElement.compareTo(iter.next()) == 0) {
            n++;
        }
    }

    for (int i = 0; i < n; i++) {
        removeElement(targetElement);
    }
}