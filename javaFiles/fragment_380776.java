@SuppressWarnings("unchecked")
public static <E> E myMethod(Class<E> cls) {
    return (E) Proxy.newProxyInstance(cls.getClassLoader(), new Class[] { cls },
        (Object proxy, Method method, Object[] arguments) -> {
            // handle the invocation of the given method
            return null; // return something actual
        });
}