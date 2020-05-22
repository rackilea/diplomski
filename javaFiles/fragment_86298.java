static void example(Supplier<? extends Factory<?>> s) {
    capture(s);
}
static <T> void capture(Supplier<? extends Factory<T>> s) {
    Factory<T> a = s.get();
    Factory<T> b = s.get();
    // remember, a and b are supposed to have the same type
    T obj = a.provide();
    b.dispose(obj);
}