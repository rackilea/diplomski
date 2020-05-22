public class MyClass<T extends MyComponent> {
    private T t;

    MyClass(Class<T> clazz) throws InstantiationException,
            IllegalAccessException {
        t = clazz.newInstance();
    }

}