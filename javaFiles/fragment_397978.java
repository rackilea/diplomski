public class ObjectMapperBuilder {
    ObjectMapper mapper;

    public ObjectMapperBuilder configure(final ObjectMapper mapper) {
        this.mapper = mapper;
        return this;
    }

    public ObjectMapperBuilder withModule(final Module module) {
        this.mapper.registerModule(module);
        return this;
    }

    public ObjectMapper build() {
        return this.mapper;
    }
}