class UnitBeanDeserializerModifier extends BeanDeserializerModifier {

    @Override
    public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
        JsonDeserializer<?> jsonDeserializer = super.modifyDeserializer(config, beanDesc, deserializer);
        if (jsonDeserializer instanceof StdScalarDeserializer) {
            StdScalarDeserializer scalarDeserializer = (StdScalarDeserializer) jsonDeserializer;
            Class scalarClass = scalarDeserializer.handledType();
            if (int.class == scalarClass) {
                return new UnitIntStdScalarDeserializer(scalarDeserializer);
            }
        }
        return jsonDeserializer;
    }
}