private List<Field> getInheritedPrivateFields(Class<?> type) {
    List<Field> result = new ArrayList<Field>();

    Class<?> i = type;
    while (i != null && i != Object.class) {
        Collections.addAll(result, i.getDeclaredFields());
        i = i.getSuperclass();
    }

    return result;
}