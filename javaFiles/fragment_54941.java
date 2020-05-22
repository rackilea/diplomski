public class Container<T> {
    private T element;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Container(T someElement) {
        this.element = someElement;
    }
}