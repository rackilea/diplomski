private static Object invkGen(Object passedObj, String attributeName) throws Exception {
    final String[] split = attributeName.split("\\.");
    Object result = passedObj;
    for (String s : split) {
        if (result == null) {
            break;
        }
        result = invk(result, s);
    }
    return result;
}

private static Object invk(Object passedObj, String attributeName) throws Exception {
    Object result = null;
    final Field[] fields = passedObj.getClass().getDeclaredFields();

    for (Field field : fields) {
        JsonProperty jsonProperty = field.getDeclaredAnnotation(JsonProperty.class);
        if (jsonProperty != null && jsonProperty.value().equals(attributeName)) {
            result = Person.class.getMethod("get" + capitalize(field.getName())).invoke(passedObj);
        } else {
            if (field.getName().equals(attributeName)) {
                result = passedObj.getClass().getMethod("get" + capitalize(field.getName()))
                    .invoke(passedObj);
            }
        }
    }
    return result;
}