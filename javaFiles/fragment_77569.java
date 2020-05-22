public class MyGenericClass<T extends MyBaseObject> {
    private T value;
    public MyGenericClass(T value) {
        this.value = value;
    }
}