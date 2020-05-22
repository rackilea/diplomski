while (r > 0) {
    T element = array.get(--r);
    if (element.compareTo(pivot) <= 0) {
        break;
    }
}