public abstract class ValueHolder<T extends Comparable<T>> extends Node<T> {

    private Class<T> type;
    private T data;

    @SuppressWarnings("unchecked")
    public ValueHolder() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getType() {
        return type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setData(Object data) {
        this.data = type.cast(data);
    }

}