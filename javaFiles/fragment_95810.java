public class MyStack<T> {

    int index;
    private Object[] data;
    private final Class<T> elementType;

    public MyStack(Class<T> elementType) {
        this.elementType = elementType;
        index = 0;
        data = new Object[5];
    }