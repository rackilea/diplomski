public static <T> validateBean(T myBean) throws IllegalAccessException {
    Field[] fields = myBean.getClass().getDeclaredFields();
    // This does not take fields of superclass into account
    if (fields != null) {
        for (Field field : allFields) {
            if (field.isAnnotationPresent(ValideStringIsCapitalCase.class)) {
                field.setAccessible(true);
                Object value = field.get(existingEntity);
                // Validate
                field.setAccessible(false);
            }
        }
    }
}