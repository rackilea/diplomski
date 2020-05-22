public class TestBeanSerializationModifiers {

    static final String PropertyName = "customProperty";
    static final String CustomValue = "customValue";
    static final String BaseValue = "baseValue";

    // Custom serialization

    static class CustomSerializer extends JsonSerializer<Object> {
        @Override
        public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            String customValue = CustomValue; // someService.getCustomValue(value);
            jgen.writeString(customValue);
        }
    }

    static class MyBeanSerializerModifier extends BeanSerializerModifier {
        @Override
        public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BasicBeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
            for (int i = 0; i < beanProperties.size(); i++) {
                BeanPropertyWriter beanPropertyWriter = beanProperties.get(i);
                if (PropertyName.equals(beanPropertyWriter.getName())) {
                    beanProperties.set(i, beanPropertyWriter.withSerializer(new CustomSerializer()));
                }
            }
            return beanProperties;
        }
    }

    // Custom deserialization

    static class CustomDeserializer extends JsonDeserializer<Object> {
        @Override
        public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            // serialized value, 'customValue'
            String serializedValue = jp.getText();
            String baseValue = BaseValue; // someService.restoreOldValue(serializedValue);
            return baseValue;
        }
    }

    static class MyBeanDeserializerModifier extends BeanDeserializerModifier {
        @Override
        public BeanDeserializerBuilder updateBuilder(DeserializationConfig config, BasicBeanDescription beanDesc, BeanDeserializerBuilder builder) {
            Iterator<SettableBeanProperty> beanPropertyIterator = builder.getProperties();
            while (beanPropertyIterator.hasNext()) {
                SettableBeanProperty settableBeanProperty = beanPropertyIterator.next();
                if (PropertyName.equals(settableBeanProperty.getName())) {
                    SettableBeanProperty newSettableBeanProperty = settableBeanProperty.withValueDeserializer(new CustomDeserializer());
                    builder.addOrReplaceProperty(newSettableBeanProperty, true);
                    break;
                }
            }
            return builder;
        }
    }

    static class Model {

        private String customProperty = BaseValue;
        private String[] someArray = new String[]{"one", "two"};

        public String getCustomProperty() {
            return customProperty;
        }

        public void setCustomProperty(String customProperty) {
            this.customProperty = customProperty;
        }

        public String[] getSomeArray() {
            return someArray;
        }

        public void setSomeArray(String[] someArray) {
            this.someArray = someArray;
        }
    }

    public static void main(String[] args) {
        SerializerFactory serializerFactory = BeanSerializerFactory
                .instance
                .withSerializerModifier(new MyBeanSerializerModifier());

        DeserializerFactory deserializerFactory = BeanDeserializerFactory
                .instance
                .withDeserializerModifier(new MyBeanDeserializerModifier());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializerFactory(serializerFactory);
        objectMapper.setDeserializerProvider(new StdDeserializerProvider(deserializerFactory));

        try {
            final String fileName = "test-serialization.json";
            // Store, "customValue" -> json
            objectMapper.writeValue(new File(fileName), new Model());
            // Restore, "baseValue" -> model
            Model model = objectMapper.readValue(new File(fileName), Model.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}