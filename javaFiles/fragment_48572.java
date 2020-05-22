public static Class<?> getOriginalClass(Object obj) {
    Class<?> cls = obj.getClass();
    if (cls.isAnonymousClass()) {
        return cls.getInterfaces().length == 0 ? cls.getSuperclass() : cls.getInterfaces()[0];
    } else {
        return cls;
    }
}