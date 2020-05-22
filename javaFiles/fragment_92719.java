public class QueryDeserializer extends JsonDeserializer<Query> {

    @Override
    public Query deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {

        JsonNode node = jp.getCodec().readTree(jp);

        Iterator<Entry<String, JsonNode>> nodeIterator = node.fields();

        Query query = new Query();
        Map<String, String> other = new HashMap<>();

        while (nodeIterator.hasNext()) {
            Map.Entry<String, JsonNode> entry = nodeIterator.next();
            Field field = getField(entry.getKey());

            if (field != null) {
                try {
                    field.set(query, entry.getValue().textValue());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                other.put(entry.getKey(), entry.getValue().textValue());
            }
        }

        if (other.size() != 0) {
            query.setOther(other);
        }

        return query;
    }

    public static Field getField(String entryName) {
        for (Field field : Query.class.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName;
            if (field.isAnnotationPresent(JsonProperty.class)) {
                fieldName = field.getAnnotation(JsonProperty.class).value();
            } else {
                fieldName = field.getName();
            }
            if (entryName.equalsIgnoreCase(fieldName)) {
                return field;
            }
        }
        return null;
    }
}