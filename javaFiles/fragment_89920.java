@Override
public T next() {
    T data = current.obj;
    current = current.next;
    return data;
}