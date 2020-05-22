SimpleModule module = new SimpleModule();
module.setDeserializerModifier(new BeanDeserializerModifier() {
    @Override
    public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
        if (beanDesc.getBeanClass() == User.class)
            return new UserDeserializer(deserializer);
        return deserializer;
    }
});
environment.getObjectMapper().registerModule(module);