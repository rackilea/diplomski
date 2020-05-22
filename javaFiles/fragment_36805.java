public static void setEmpty(Object object) throws IllegalArgumentException, IllegalAccessException {
    Class<?> clazz = object.getClass();
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
        if (String.class.equals(field.getType())) {
            field.setAccessible(true);
            if (field.get(object) == null) {
                field.set(object, "");
            }
        }
    }
}