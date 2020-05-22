/**
 * Returns an enumeration that has no elements.  More precisely,
 *
  ...
 * @since 1.7
 */
@SuppressWarnings("unchecked")
public static <T> Enumeration<T> emptyEnumeration() {
    return (Enumeration<T>) EmptyEnumeration.EMPTY_ENUMERATION;
}

private static class EmptyEnumeration<E> implements Enumeration<E> {
    static final EmptyEnumeration<Object> EMPTY_ENUMERATION
        = new EmptyEnumeration<>();

    public boolean hasMoreElements() { return false; }
    public E nextElement() { throw new NoSuchElementException(); }
    public Iterator<E> asIterator() { return emptyIterator(); }
}