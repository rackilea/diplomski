class C {
    private static final Object myObject = makeObject(); // OK now

    private static Object makeObject() { // no 'throws'
        try {
           ...
        } catch (IOException e) {
            ...
            throw new RuntimeException(e); // wrap here
        }
    }
}