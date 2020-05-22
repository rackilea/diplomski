public ObjectMapper getMapperWithCustomDeserializer() {
    ObjectMapper objectMapper = new ObjectMapper();

    SimpleModule module = new SimpleModule();
    module.setDeserializerModifier(new BeanDeserializerModifier() {
        @Override
        public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config,
                    BeanDescription beanDesc, JsonDeserializer<?> defaultDeserializer) 
            if (beanDesc.getBeanClass() == User.class) {
                return new UserDeserializer(defaultDeserializer);
            } else {
                return defaultDeserializer;
            }
        }
    });
    objectMapper.registerModule(module);

    return objectMapper;
}