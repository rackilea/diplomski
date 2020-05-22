public class MapAsArraySerializer extends JsonSerializer<Map> {

    @SuppressWarnings("unchecked")
    private Set asListOfLists(Map<?, ?> value) {
        Set returned = new HashSet<>();
        for(Map.Entry e : value.entrySet()) {
            returned.add(Arrays.asList(e.getKey(), e.getValue()));
        }
        return returned;
    }

    @Override
    public void serialize(Map value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        Collection entries = asListOfLists(value);
        jgen.writeObjectField("entries", entries);
    }

    @Override
    public void serializeWithType(Map value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer) throws IOException,
                    JsonProcessingException {
        Collection entries = asListOfLists(value);
        typeSer.writeTypePrefixForObject(value, jgen);
        jgen.writeObjectField("entries", entries);
        typeSer.writeTypeSuffixForObject(value, jgen);
    }
}