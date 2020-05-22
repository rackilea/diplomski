public Method[] getMethods(Class<?> c) {
    List<Method> methods = new ArrayList<Method>();
    while (c != Object.class) {
        methods.addAll(Arrays.asList(c.getDeclaredMethods()));
        c = c.getSuperclass();
    }

    return methods.toArray(new Method[methods.size()]);
}