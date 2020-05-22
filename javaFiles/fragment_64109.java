class TimestampAdapter<T> extends TypeAdapter<T> {
    private TypeToken<T> type;
    private Gson gson = new GsonBuilder().create();

    public TimestampAdapter(TypeToken<T> type) {
        this.type = type;
    }

    @Override
    public void write(JsonWriter out, T value) throws IOException {
        JsonObject object = appendIsoTimestamps(value, (JsonObject) gson.toJsonTree(value));
        TypeAdapters.JSON_ELEMENT.write(out, object);
    }

    private JsonObject appendIsoTimestamps(T src, JsonObject tree) {
        try {
            PropertyDescriptor[] descriptors = Introspector.getBeanInfo(src.getClass()).getPropertyDescriptors();
            for (PropertyDescriptor descriptor : descriptors) {
                if (descriptor.getPropertyType().equals(Timestamp.class)) {
                    Timestamp ts = (Timestamp) descriptor.getReadMethod().invoke(src);
                    tree.addProperty("iso_" + descriptor.getName(), ts.toInstant().toString());
                }
            }
            return tree;
        } catch (IllegalAccessException | InvocationTargetException | IntrospectionException e) {
            throw new JsonIOException(e);
        }
    }

    @Override
    public T read(JsonReader in) {
        return gson.fromJson(in, type.getType());
    }
}