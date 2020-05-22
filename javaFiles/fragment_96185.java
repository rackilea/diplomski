public T findById(String id) throws Exception {
    Field[] declaredFields = TClass.getDeclaredFields();
    Field idField = null;
    for (Field field: declaredFields) {
        if (field.isAnnotationPresent(Id.class)) {
            idField = field;
            break;
        }
    }
    if (idField == null) {
        throw new IllegalStateException("No field annotated with @Id");
    }
    Class<?> type = idField.getType();
    Object pk = id;
    if (type == Integer.class) {
        pk = Integer.parseInt(id);
    }
    return manager.find(TClass, pk);
}