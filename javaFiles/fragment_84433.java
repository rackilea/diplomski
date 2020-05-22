public static void copyObject(Object src, Object dest)
        throws IllegalArgumentException, IllegalAccessException,
        NoSuchFieldException, SecurityException {
    for (Field field : src.getClass().getFields()) {
        dest.getClass().getField(field.getName()).set(dest, field.get(src));
    }
}