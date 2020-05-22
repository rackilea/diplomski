@SafeVarargs
final <T> void foo(T... args) {
    for (T x : args) {
        // do stuff with x
    }
}