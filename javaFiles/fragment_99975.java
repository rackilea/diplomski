static Set<Class> getDeclaredTypes() {
    Set<Class> result = Sets.newHashSet();
    Method[] methods = Config.class.getDeclaredMethods();
    for (Method method : methods) {
        if (method.getAnnotation(Bean.class) != null) {
            result.add(method.getReturnType());
        }
    }
    return result;
}