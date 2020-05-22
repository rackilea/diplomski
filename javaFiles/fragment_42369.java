public int size() {
    if (size == 0)
        return 0;
    expungeStaleEntries();
    return size;
}