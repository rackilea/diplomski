@Override
public boolean addAll(Collection<? extends E> c) {
    boolean result = false;
    for (E e : c) {
        if (add(e)) {
           result = true;
        }
    }
    return result;
}