List<T> listCopy;

synchronized (list) {
    listCopy = new ArrayList(list);
}

// Use listCopy for displaying the value rather than list