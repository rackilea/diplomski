private int size;

public Pile(int newSize) {
    size = newSize;
}

public boolean takeMarbles(int amount) {
    size -= amount;
    if (size < 1)
        return false;
    return true;
}