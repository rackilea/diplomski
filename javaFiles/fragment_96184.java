public T findById(String id) throws Exception {
    Field idField = TClass.getDeclaredField("id");
    Class<?> type = idField.getType();
    Object pk = id;
    if (type == Integer.class) {
        pk = Integer.parseInt(id);
    }
    return manager.find(TClass, pk);
}