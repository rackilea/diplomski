private static final ConcurrentMap<Class<?>,List<Method>> METHODS = new ConcurrentHashMap<>();
...
Clazz<?> clazz = getClass();
METHODS.computeIfAbsent(clazz, c -> findMethods(c));
...
private static List<Method> findMethods(Class<?> clazz) {
    final List<Method> methods = new ArrayList<>(16);
    while (clazz != Object.class) {
        for (final Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                methods.add(method);
            }
        }
        clazz = clazz.getSuperclass();
    }
    return methods;
}