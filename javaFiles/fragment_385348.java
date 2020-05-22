public  class TestBuilder<T, O> {
    public static <T> TestBuilder<T, T>  create(Class<T> eventClass) {
        return new TestBuilder<T, T>(eventClass);
    }
    // ...
}