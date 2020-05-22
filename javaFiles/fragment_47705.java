public static class Test<T> {
    <T extends Comparable<T>> void compareMethod(T t, Class<T> classt) {
    }
    void normalMethod(T t) {
    }
}