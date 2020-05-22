private static final AtomicState as = new AtomicState();

public AtomicInteger ai = new AtomicInteger();

private AtomicState() {

}

public AtomicInteger getAtomicIntegerObj() {
    return ai;
}


public static AtomicState getAtomicState() {
    return as;
}