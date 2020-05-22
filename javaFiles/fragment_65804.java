class MixedJsonSerializer implements JsonSerializer<Object> {

    @Override
    public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = serialiseAsMap(src, context);
        serialiseAsPojo(src, context, json);

        return json;
    }

    private JsonObject serialiseAsMap(Object src, JsonSerializationContext context) {
        return (JsonObject) context.serialize(src, Map.class);
    }

    private void serialiseAsPojo(Object src, JsonSerializationContext context, JsonObject mapElement) {
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(src.getClass());
        for (Method method : methods) {
            if (shouldSerialise(method)) {
                final Object result = ReflectionUtils.invokeMethod(method, src);
                final String fieldName = getFieldName(method);
                mapElement.add(fieldName, context.serialize(result));
            }
        }
    }

    private boolean shouldSerialise(Method method) {
        final String name = method.getName();

        return method.getParameterCount() == 0 &&
                ReflectionUtils.USER_DECLARED_METHODS.matches(method) &&
                !IGNORED_METHODS.contains(name) &&
                (name.startsWith("is") || name.startsWith("get"));
    }

    private static final List<String> IGNORED_METHODS = Arrays.asList("isEmpty", "length"); //etc

    private String getFieldName(Method method) {
        final String field = method.getName().replaceAll("^(is|get)", "");

        return StringUtils.uncapitalize(field);
    }
}