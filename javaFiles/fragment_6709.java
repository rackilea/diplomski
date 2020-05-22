@Override
public boolean addAll(Collection<? extends E> c) {
    boolean result = false;
    for (E e : c) {
        result = add(e) || result;
    }
    return result;
}