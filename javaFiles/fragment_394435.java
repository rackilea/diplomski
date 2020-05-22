public static Field[] getAllFields(Class<?> klass) {
    List<Field> fields = new ArrayList<>();
    for(; klass!=null; klass=klass.getSuperclass())
        Collections.addAll(fields, klass.getDeclaredFields());
    return fields.toArray(new Field[0]);
}