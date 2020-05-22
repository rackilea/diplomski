class TypeAwareListJsonAdapter implements JsonSerializer<List<?>>, JsonDeserializer<List<?>> {

    private final String typeProperty = "@type";

    @Override
    public JsonElement serialize(List<?> src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null) {
            return JsonNull.INSTANCE;
        }
        JsonArray array = new JsonArray();
        for (Object item : src) {
            JsonObject jsonElement = (JsonObject) context.serialize(item, item.getClass());
            jsonElement.addProperty(typeProperty, item.getClass().getSimpleName());

            array.add(jsonElement);
        }
        return array;
    }

    @Override
    public List<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final Type elementType = $Gson$Types.getCollectionElementType(typeOfT, List.class);

        if (json instanceof JsonArray) {
            final JsonArray array = (JsonArray) json;
            final int size = array.size();
            if (size == 0) {
                return Collections.emptyList();
            }

            final List<?> suites = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                JsonObject jsonElement = (JsonObject) array.get(i);
                String simpleName = jsonElement.get(typeProperty).getAsString();
                suites.add(context.deserialize(jsonElement, getClass(simpleName, elementType)));
            }

            return suites;
        }

        return Collections.emptyList();
    }

    private Type getClass(String simpleName, Type defaultType) {
        try {
            // you can use mapping or something else...
            return Class.forName("com.model." + simpleName);
        } catch (ClassNotFoundException e) {
            return defaultType;
        }
    }
}