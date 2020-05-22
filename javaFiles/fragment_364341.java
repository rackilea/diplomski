public class Something {
    private Something() {
    }

    private static class LazyHolder {
        private static final Something something = new Something();
    }

    public static Something getInstance() {
        return LazyHolder.something;
    }
}