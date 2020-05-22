public static void main(String[] args) {
    SomeAutoCloseableThing thing = new SomeAutoCloseableThing();
    try {
        throw new IllegalStateException("running failed");
    } finally {
        try {
            thing.close();
        } catch (Exception e) {
            LoggerFactory.getLogger(Main.class).error("An error occurred while closing SomeAutoCloseableThing", e);
        }
    }
}