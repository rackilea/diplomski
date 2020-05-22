private static class SomeAutoCloseableThing implements AutoCloseable {

    @Override
    public void close() {
        throw new IllegalStateException("closing failed");
    }

}

public static void main(String[] args) {
    try (SomeAutoCloseableThing thing = new SomeAutoCloseableThing()) {
        throw new IllegalStateException("running failed");
    }
}