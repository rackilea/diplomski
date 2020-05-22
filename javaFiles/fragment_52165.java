private static Method tryFindInterfaceMethod(Method m) throws Exception {
    for (Class bc : m.getDeclaringClass().getInterfaces()) {
        try {
    return bc.getMethod(m.getName(), m.getParameterTypes());
        } catch (NoSuchMethodException ignore) {
        }
    }
    return m;
}