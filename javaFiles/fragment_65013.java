class C {
    private static final Object myObject;

    static {
        try {
            myObject = makeObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Object makeObject() throws IOException {
        try {
           ...
        } catch (IOException e) {
            ...
            throw e;
        }
    }
}