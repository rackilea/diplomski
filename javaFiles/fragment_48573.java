public static Class<?> getOriginalClass(Object obj) {
    Class<?> cls = obj.getClass();
    return cls.isAnonymousClass()
            ? cls.getInterfaces().length == 0 ? cls.getSuperclass() : cls.getInterfaces()[0]
            : cls;
}