class ListDeserializer extends JsonDeserializer<CustomList> {
    @Override
    public CustomList deserialize(JsonParser p, DeserializationContext c) throws IOException {
        return ListUtils.createCustomList();
    }
}