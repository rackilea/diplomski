for (Iterator<T> iterator = list.iterator(); iterator.hasNext(); ) {
    T element = iterator.next();
    if (element.equals(elementToRemove)) {
        iterator.remove();
    }
}