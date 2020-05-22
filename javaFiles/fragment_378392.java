@SuppressWarnings("unchecked")
public static <S, T1, T2> S convert(Object[] inputobject, Class<S> mapType,
        Class<T1> keyType, Class<T2> valueType)
        throws IllegalAccessException, InstantiationException {
    Map<T1, T2> map = (Map<T1, T2>) mapType.newInstance();
    map.put((T1) inputobject[0], (T2) inputobject[1]);
    return (S) map;
}