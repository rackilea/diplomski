public LinkedHashSet(int initialCapacity, float loadFactor) {
    super(initialCapacity, loadFactor, true);      // <-- boolean dummy argument
}

...

public LinkedHashSet(int initialCapacity) {
    super(initialCapacity, .75f, true);            // <-- boolean dummy argument
}

...

public LinkedHashSet() {
    super(16, .75f, true);                         // <-- boolean dummy argument
}

...

public LinkedHashSet(Collection<? extends E> c) {
    super(Math.max(2*c.size(), 11), .75f, true);   // <-- boolean dummy argument
    addAll(c);
}