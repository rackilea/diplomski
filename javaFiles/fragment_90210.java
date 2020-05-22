class MyClass<T extends Enum<T>> {
    private Class<T> enumType;

    public MyClass(Class<T> enumType) {
        this.enumType = enumType;
    }

    public T getValue() {
        // ...
    }
}