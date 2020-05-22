public static void main(String[] args) throws NoSuchFieldException {
      System.out.println(isRequired(Employee.class, "email"));
}

private static boolean isRequired(Class<?> entity, String propertyName) throws NoSuchFieldException {
    Field property = entity.getDeclaredField(propertyName);

    final JoinColumn joinAnnotation = property.getAnnotation(JoinColumn.class);
    if (null != joinAnnotation) {
        return !joinAnnotation.nullable();
    }

    final Column columnAnnotation = property.getAnnotation(Column.class);
    if (null != columnAnnotation) {
        return !columnAnnotation.nullable();
    }

    return false;
}