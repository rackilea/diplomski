boolean testForDuplicates(Set<Object> noduplicates2) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, IntrospectionException {
    Map<Object, Object> duplicatesMap = new HashMap<Object, Object>();
    for (Object object : noduplicates2) {
        duplicatesMap.put(object.getClass(), object);
    }

    for (Object object : noduplicates2) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (duplicatesMap.containsKey(field.getType())) {
                Object possibleDupeFromField = duplicatesMap.get(field.getType());
                if (noduplicates2.contains(possibleDupeFromField)) {
                    return true;
                }
            }
        }
    }
    return false;
}