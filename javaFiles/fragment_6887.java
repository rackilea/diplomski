public static Method findMethod(Class parent, String name, Class... parameters) throws NoSuchMethodException {

    Method method = null;
    try {
        method = parent.getDeclaredMethod(name, parameters);
    } catch (NoSuchMethodException exp) {
        try {
            method = parent.getMethod(name, parameters);
        } catch (NoSuchMethodException nsm) {
            if (parent.getSuperclass() != null) {
                method = findMethod(parent.getSuperclass(), name, parameters);
            } else {
                throw new NoSuchMethodException("Could not find " + name);
            }
        }
    }
    return method;
}