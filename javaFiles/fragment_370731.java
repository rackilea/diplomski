public T get(int i) {
    if (i < 0 || i > n - 1)
        throw new IndexOutOfBoundsException();
    // TODO: Implement this
    Node u = head;
    for (int j = 0; j < i; j++)
        u = u.next;
    return u.x;
}