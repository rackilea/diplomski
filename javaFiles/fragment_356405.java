public ArrayList(Collection<? extends E> c) {
    elementData = c.toArray();
    ...
}

// ArrayList
public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
}

// Arrays
public static <T,U> T[] copyOf(U[] original, int newLength,
    Class<? extends T[]> newType) {
    ...
    System.arraycopy(original, 0, copy, 0,
        Math.min(original.length, newLength));
}

// System
public static native void arraycopy(Object src,  int  srcPos,
    Object dest, int destPos, int length);