public boolean retainAll(MyList<E> otherList) {
    boolean changed = false;
    for (int i = size() - 1; i >= 0; i--) {
        Object obj = get(i);
        if (!otherList.contains(obj)) {
            remove(i);
            changed = true;
        }
    }
    return changed;
}