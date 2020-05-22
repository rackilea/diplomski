class OmitListTypeDeserializerModifier extends BeanDeserializerModifier {

    @Override
    public JsonDeserializer<?> modifyCollectionDeserializer(DeserializationConfig config, CollectionType type, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
        if (deserializer instanceof CollectionDeserializer) {
            return new OmitListTypeJsonDeserializer((CollectionDeserializer) deserializer);
        }

        return deserializer;
    }
}