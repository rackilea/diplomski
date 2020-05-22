public static LinkedMultiValueMap<String, String> toUrlParams(Object value) {
    final LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    final List<Field> declaredFields = getAllFields(value);
    for (Field field : declaredFields) {
        ReflectionUtils.makeAccessible(field);
        final String name = field.getName();
        final Object fieldVal = ReflectionUtils.getField(field, value);
        mapFields(params, name, fieldVal);
    }
    return params;
}

private static List<Field> getAllFields(Object t) {
    final List<Field> fields = new ArrayList<>();
    Class clazz = t.getClass();
    while (clazz.getSuperclass() != null) {
        final Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            final int modifiers = field.getModifiers();
            if (!(Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers))) {
                fields.add(field);
            }
        }
        clazz = clazz.getSuperclass();
    }
    return fields;
}

private static void mapFields(LinkedMultiValueMap<String, String> params,
                              String fieldName,
                              @Nullable Object fieldVal) {
    if (fieldVal != null) {
        final Class<?> fieldClass = fieldVal.getClass();
        if (BeanUtils.isSimpleValueType(fieldClass) || fieldVal instanceof Number || fieldVal instanceof UUID) {
            if (fieldClass.isEnum()) {
                params.add(fieldName, ((Enum) fieldVal).name());
            } else {
                params.add(fieldName, fieldVal.toString());
            }
        } else {
            if (fieldVal instanceof Map) {
                throw new IllegalArgumentException("Map is not allowed for url params");
            }
            if (fieldVal instanceof List) {
                final Iterator iterator = ((Iterable) fieldVal).iterator();
                int i = 0;
                while (iterator.hasNext()) {
                    final Object iterElement = iterator.next();
                    mapFields(params, fieldName + "[" + i + "]", iterElement);
                    i++;
                }
            } else {
                if (fieldVal instanceof Set) {
                    for (Object iterElement : ((Iterable) fieldVal)) {
                        mapFields(params, fieldName, iterElement);
                    }
                } else {
                    if (fieldVal instanceof Collection) {
                        throw new IllegalArgumentException("Unknown collection, expected List or Set, but was " + fieldVal.getClass());
                    }
                    if (fieldVal.getClass().isArray()) {
                        final int length = Array.getLength(fieldVal);
                        for (int i = 0; i < length; i++) {
                            Object arrayElement = Array.get(fieldVal, i);
                            mapFields(params, fieldName + "[" + i + "]", arrayElement);
                        }
                    } else {
                        final List<Field> declaredFields = getAllFields(fieldVal);

                        for (Field field : declaredFields) {
                            ReflectionUtils.makeAccessible(field);
                            final String name = field.getName();
                            final Object nestedField = ReflectionUtils.getField(field, fieldVal);
                            mapFields(params, fieldName + "." + name, nestedField);
                        }
                    }
                }
            }
        }
    }
}