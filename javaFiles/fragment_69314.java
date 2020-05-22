public class PersonSerializer extends JsonSerializer<PersonSerializer> {

    static class BeanSerializerFactoryWithVisibleConstructingMethod extends BeanSerializerFactory {

        BeanSerializerFactoryWithVisibleConstructingMethod() {
            super(BeanSerializerFactory.instance.getFactoryConfig());
        }

        @Override
        public JsonSerializer<Object> constructBeanSerializer(SerializerProvider prov, BeanDescription beanDesc) throws JsonMappingException {
            return super.constructBeanSerializer(prov, beanDesc);
        }

    }

    private final BeanSerializerFactoryWithVisibleConstructingMethod defaultBeanSerializerFactory = new BeanSerializerFactoryWithVisibleConstructingMethod();

    private final JavaType javaType = TypeFactory.defaultInstance().constructType(Person.class);

    @Override
    public void serialize(Person value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        Person safePerson = PrivacyService.getSafePerson(value);
        JavaType type = TypeFactory.defaultInstance().constructType(Person.class);
        BeanDescription beanDescription = provider.getConfig().introspect(type);
        JsonSerializer<Object> defaultSerializer = defaultBeanSerializerFactory.constructBeanSerializer(provider, beanDescription);
        defaultSerializer.serialize(safePerson, jgen, provider);
    }

}