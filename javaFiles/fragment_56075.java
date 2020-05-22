class Bean {
    @Ignore
    String a;
    String b;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Ignore {

}

class BeanWithIgnoredFieldsSerializer extends JsonSerializer<Bean> {

    @Override
    public void serialize(final Bean value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        try {
            for (final Field f : Bean.class.getFields()) {
                if (f.isAnnotationPresent(Ignore.class)) {
                    gen.writeStringField(f.getName(), (String) f.get(value));
                }
            }
        } catch (final Exception e) {
            //
        }
        gen.writeEndObject();
    }

}

class BeanModule extends SimpleModule {

    BeanModule() {
        addSerializer(Bean.class, new BeanWithIgnoredFieldsSerializer());
    }
}

void configure(final ObjectMapper om) {
    om.registerModule(new BeanModule());
}