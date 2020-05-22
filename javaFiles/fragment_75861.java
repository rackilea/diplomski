import java.lang.reflect.ParameterizedType;

public class Array<T> {
    public T[] nodes;
    Class<T> persistentClass;
    int size;

    @SuppressWarnings("unchecked")
    public Array() {
        size = 0;
        ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
        persistentClass = (Class<T>) paramType.getActualTypeArguments()[0];
    }

    public void insert(T e) {
        T[] tempNodes = (T[]) java.lang.reflect.Array.newInstance(persistentClass, size + 1);
        for (int i = 0; i < size; i++) {
            tempNodes[i] = nodes[i];
        }
        nodes = tempNodes;
        nodes[size] = e;
        size++;
    }
}