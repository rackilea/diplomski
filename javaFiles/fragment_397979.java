public class SimpleModuleBuilder {
    SimpleModule module;

    public SimpleModuleBuilder configure(final SimpleModule module) {
        this.module = module;
        return this;
    }

    public <X> SimpleModuleBuilder withSerializer(final Class<X> clazz, final JsonSerializer<X> serializer) {
        this.module.addSerializer(clazz, serializer);
        return this;
    }

    public <X> SimpleModuleBuilder withDeserializer(final Class<X> clazz, final JsonDeserializer<X> deserializer) {
        this.module.addDeserializer(clazz, deserializer);
        return this;
    }

    public SimpleModule build() {
        return this.module;
    }
}