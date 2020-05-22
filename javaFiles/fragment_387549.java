public class MyGenericClass<T> {

    private final Class<T> clazz;

    public static <U> MyGenericClass<U> createMyGeneric(Class<U> clazz) {
        return new MyGenericClass<U>(clazz);
    }

    protected MyGenericClass(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void doSomething() {
        T instance = clazz.newInstance();
    }
}