public Set<T> union(Set<T> anotherSet) {
    ResizableArraySet<T> newSet = new ResizableArraySet<>();
    for (int i = 0; i < numberOfEntries; i++) {
        newSet.add(array[i]);
    }
    Iterator<T> it = anotherSet.iterator();
    while (it.hasNext()) {
        T el = it.next();
        if (!newSet.contains(el)) {
            newSet.add(el);
        }
    }
    return newSet;
}