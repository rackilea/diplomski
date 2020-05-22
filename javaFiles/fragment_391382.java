@SuppressWarnings("unchecked")
public <T> T[] insertInCopy(T[] src, T obj, int i) throws Exception {
    T[] dst = (T[]) Array.newInstance(src.getClass().getComponentType(), src.length + 1);
    System.arraycopy(src, 0, dst, 0, i);
    dst[i] = obj;
    System.arraycopy(src, i, dst, i + 1, src.length - i);
    return dst;
}