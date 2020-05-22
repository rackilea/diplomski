private static class MultisetDeserializer implements JsonDeserializer<Multiset<?>> {
    @Override
    public Multiset<?> deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] typeArguments = parameterizedType.getActualTypeArguments();

        ParameterizedType listType = new ListParameterizedType(typeArguments);
        List<?> list = context.deserialize(json, listType);

        return HashMultiset.create(list);
    }
}