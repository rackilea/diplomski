@Override
public void serialize(Person value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
    Person safePerson = PrivacyService.getSafePerson(value);
    ObjectMapper objectMapper = (ObjectMapper)jgen.getCodec();
    Class<?> entityClass = value.getClass();
    JavaType javaType = TypeFactory.defaultInstance().constructType(entityClass);
    DefaultSerializerProvider.Impl defaultSerializerProvider = (DefaultSerializerProvider.Impl) objectMapper.getSerializerProviderInstance();
    BeanSerializerFactory factoryIgnoringCustomSerializerOnRootClass = new BeanSerializerFactory(BeanSerializerFactory.instance.getFactoryConfig()) {
        @Override
        protected JsonSerializer<Object> findSerializerFromAnnotation(SerializerProvider prov, Annotated a) throws JsonMappingException {
            JsonSerializer<Object> result = javaType.equals(a.getType()) ? null : super.findSerializerFromAnnotation(prov, a);
            return result;
        }
    };
    DefaultSerializerProvider.Impl updatedSerializerProvider = defaultSerializerProvider.createInstance(defaultSerializerProvider.getConfig(), factoryIgnoringCustomSerializerOnRootClass);
    updatedSerializerProvider.serializeValue(jgen, value);
}