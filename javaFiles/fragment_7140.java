public static <T> Map<String, Object> getDefaultValues(Class<T> clazz, T instance) throws Exception {
    Map<String, Object> defaultValues = new HashMap<String, Object>();
    if (instance == null) {
        instance = clazz.newInstance();
    }
    for (Field field : clazz.getDeclaredFields()) {
        field.setAccessible(true);
        Object defaultValue = field.get(instance);
        defaultValues.put(field.getName(), defaultValue);
    }
    return defaultValues;
}