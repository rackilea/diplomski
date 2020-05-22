public Object getType(String methodName, Class<?> clazz) throws Exception {
    String name = methodName;
    Method[] methods = clazz.getMethods();
    for (int i = 0; i < methods.length; i++) {
        if (name.equals(methods[i].getName())) {
            return methods[i].getReturnType();
        }
    }
    return null;
}