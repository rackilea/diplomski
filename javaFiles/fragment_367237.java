public ArrayList() {
    this(10);   // Here the 10 of the default capacity
}

public ArrayList(int initialCapacity) {
    super();
    if (initialCapacity < 0)
        throw new IllegalArgumentException("Illegal Capacity: "+
                                                initialCapacity);
    this.elementData = new Object[initialCapacity];
}