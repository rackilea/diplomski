public enum Foo {
    VALUE1, VALUE2, VALUE3;
    private static JAXBReader singleReader;

    static {
        singleReader = null; // Don't need it any more
    }

    private Foo() {
        JAXBReader reader = getReader();
        // Use the reader
    }

    private static JAXBReader getReader() {
        // We don't need to worry about thread safety, as all of this
        // will be done in a single thread initializing the enum
        if (singleReader == null) {
            // This will only happen once
            singleReader = new JAXBReader(...);
        }
        return singleReader;
    }
}