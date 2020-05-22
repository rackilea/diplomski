public static void main(String[] args) {
    SomeAutoCloseableThing thing = new SomeAutoCloseableThing();
    try {
        throw new IllegalStateException("running failed");
    } finally {
        thing.close();
    }
}