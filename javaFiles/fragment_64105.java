/**
 * Appends extra fields containing ISO formatted times for all Timestamp properties of an Object.
 */
class TimestampSerializer implements JsonSerializer<Object> {
    private Gson gson = new GsonBuilder().create();

    @Override
    public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
        JsonElement tree = gson.toJsonTree(src);
        if (tree instanceof JsonObject) {
            appendIsoTimestamps(src, (JsonObject) tree);
        }
        return tree;
    }

    private JsonObject appendIsoTimestamps(Object src, JsonObject object) {
        try {
            PropertyDescriptor[] descriptors = Introspector.getBeanInfo(src.getClass()).getPropertyDescriptors();
            for (PropertyDescriptor descriptor : descriptors) {
                if (descriptor.getPropertyType().equals(Timestamp.class)) {
                    Timestamp ts = (Timestamp) descriptor.getReadMethod().invoke(src);
                    object.addProperty("iso_" + descriptor.getName(), ts.toInstant().toString());
                }
            }
            return object;
        } catch (IllegalAccessException | InvocationTargetException | IntrospectionException e) {
            throw new JsonIOException(e);
        }
    }