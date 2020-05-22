public static <T extends Buffer> T endianPreservingDuplicate(T b) throws Exception {
    Class<?> clazz = b.getClass();
    Method getOrder = getMethod(clazz, "order");
    ByteOrder orderTemp = (ByteOrder) getOrder.invoke(b);
    Method duplicate = getMethod(clazz, "duplicate");
    @SuppressWarnings("unchecked") // cast is safe
    T copy = (T) duplicate.invoke(b);
    Method setOrder = getMethod(clazz, "order", ByteOrder.class);
    setOrder.invoke(copy, orderTemp);
    return copy;
}

private static Method getMethod(Class<?> clazz, String name, Class<?>...params) throws NoSuchMethodException {
    try {
        Method method = clazz.getDeclaredMethod(name, params);
        method.setAccessible(true);
        return method;
    } catch (NoSuchMethodException e) {
        Class<?> superclass = clazz.getSuperclass();
        if (!superclass.equals(Buffer.class)) {
            return getMethod(superclass, name, params);
        } else {
            throw new NoSuchMethodException("no " + name + " method");
        }
    }
}