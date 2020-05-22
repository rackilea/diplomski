MyInterface newInstance(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    Class<?> cls = Class.forName(className);
    if (!MyInterface.class.isAssignableFrom(cls)) {
        throw new IllegalArgumentException();
    }
    return (MyInterface) cls.newInstance();
}