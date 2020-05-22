public class JacksonEntity {

    @Retention(RetentionPolicy.RUNTIME)
    static public @interface MyAnnotation {
        Class<?> ref();
        Class<?> impl();
    }

    @MyAnnotation(ref = MyEntityRef.class, impl = MyEntityImpl.class)
    static public interface MyEntity {
    }

    static public class MyEntityRef implements MyEntity {
        private final String id;

        public MyEntityRef(String id) {
            this.id = id;
        }

        @JsonValue
        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "MyEntityRef{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }

    static public class MyEntityImpl implements MyEntity {
        public final String id;
        public final String name;

        @JsonCreator
        public MyEntityImpl(@JsonProperty("id") String id, @JsonProperty("name") String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyEntityImpl{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static public class MyDeserializer extends JsonDeserializer<Object> {
        private final Class<?> refType;
        private final Class<?> implType;

        public MyDeserializer(MyAnnotation annotation) {
            this.refType = annotation.ref();
            this.implType = annotation.impl();
        }

        @Override
        public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonToken jsonToken = jp.getCurrentToken();
            if (jsonToken == JsonToken.START_OBJECT) {
                return jp.readValueAs(implType);
            } else if (jsonToken == JsonToken.VALUE_STRING) {
                try {
                    return refType.getConstructor(String.class).newInstance(jp.getValueAsString());
                } catch (Exception e) {
                    throw new UnsupportedOperationException();
                }
            }
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config,
                                                          BeanDescription beanDesc,
                                                          JsonDeserializer<?> deserializer) {
                MyAnnotation myAnnotation = beanDesc.getClassAnnotations().get(MyAnnotation.class);
                // it must be interface, otherwise getting meeting recursion
                if (myAnnotation != null && beanDesc.getBeanClass().isInterface()) {
                    return new MyDeserializer(myAnnotation);
                }
                return super.modifyDeserializer(config, beanDesc, deserializer);
            }
        });
        mapper.registerModule(module);

        MyEntityRef ref = new MyEntityRef("id1");
        MyEntityImpl impl = new MyEntityImpl("id2", "value");

        String jsonRef = mapper.writeValueAsString(ref);
        System.out.println(jsonRef);
        String jsonImpl = mapper.writeValueAsString(impl);
        System.out.println(jsonImpl);

        System.out.println(mapper.readValue(jsonRef, MyEntity.class));
        System.out.println(mapper.readValue(jsonImpl, MyEntity.class));
    }
}