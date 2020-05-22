public class JacksonBuilder {
    public static final String JSON = "{\"field\":\"value\"}";

    @JsonDeserialize(builder = Builder.class)
    public static class Bean {
        public final String field;

        public Bean(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "field='" + field + '\'' +
                    '}';
        }
    }

    static interface JsonParserAware {
        void withJsonParser(JsonParser parser);
    }

    static class Builder implements JsonParserAware {
        public String field;

        private JsonParser parser;

        @Override
        public void withJsonParser(JsonParser parser) {
            this.parser = parser;
        }

        public Bean build() {
            System.out.println(parser);
            return new Bean(field + "(build by builder)");
        }
    }

    private static class MyBuilderDeserializer extends BuilderBasedDeserializer {

        protected MyBuilderDeserializer(BuilderBasedDeserializer src) {
            super(src);
            _vanillaProcessing = false;
        }

        @Override
        public Object deserializeFromObject(JsonParser jp, DeserializationContext ctxt) throws IOException {
            Object object = super.deserializeFromObject(jp, ctxt);
            if (object instanceof JsonParserAware) {
                ((JsonParserAware) object).withJsonParser(jp);
            }
            return object;
        }
    }

    private static class BuilderBeanDeserializerModifier extends BeanDeserializerModifier {
        @Override
        public JsonDeserializer<?> modifyDeserializer(
                DeserializationConfig config,
                BeanDescription beanDesc,
                JsonDeserializer<?> deserializer) {
            if (deserializer instanceof BuilderBasedDeserializer) {
                return new MyBuilderDeserializer((BuilderBasedDeserializer) deserializer);
            }
            return super.modifyDeserializer(config, beanDesc, deserializer);
        }
    }


    public static void main(String[] args) throws IOException {
        final SimpleModule module = new SimpleModule();
        module.setDeserializerModifier(new BuilderBeanDeserializerModifier());
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);
        System.out.println(mapper.readValue(JSON, Bean.class));
    }

}