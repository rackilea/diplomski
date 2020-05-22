final AtomicReference<boolean[]> booleanRefs = (
    new AtomicReference<boolean[]>(new boolean[] { true, true })
);

void somewhere() {
    boolean[] refs = booleanRefs.get();

    refs[0] = false; // not atomic!!

    boolean[] copy = booleanRefs.get().clone(); // pretty safe
    copy[0] = false;
    booleanRefs.set(copy);
}