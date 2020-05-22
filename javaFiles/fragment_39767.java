public class TestClass<T> {
    T[] array;

    @SuppressWarnings("unchecked")
    public TestClass(Class<T> type) {
        array = (T[]) Array.newInstance(type, 32);
    }

    public T[] getArray() {
        return array;
    }

    public boolean doThing() {
        T[] t = array;

        return t == array && t != null;
    }
}