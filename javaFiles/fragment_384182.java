public class MyClass<T> {
    private Class<T> clazz;

    public MyClass(Class<T> clazz) {
        this.clazz = clazz;
    }

    public String toString() {
        return String.format("Type of T: %s", clazz.getSimpleName());
    }
}