if (pointer.data.compareTo(item) < 0 && pointer.next == null) {
    store.next = pointer.next;
    pointer.next = store;

    return;

}