private Object[] data = new Object[10];
private int size = 0;

public void add(T obj) {
    data[size++] = obj;
}

public T get(int i){
    return (T) data[i];
}