private static Object getFieldClass(Class<?> currentClass, Object currentObject, final String fieldName) {

    Field[] fieldList;

    fieldList = currentClass.getDeclaredFields();

    for (final Field field : fieldList) {
        if (field.getName().toLowerCase().equals(fieldName)) {

            try {
                return field.get(currentObject);
            } catch (IllegalAccessException e) {

                e.printStackTrace();
                break;

            }

        }
    }

    return null;

}