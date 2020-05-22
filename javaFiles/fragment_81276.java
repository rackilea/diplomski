package stackoverflow;

public class JacksonTracking {
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Json {
    }

    @Json
    public static class A {
        public final String field1;

        public A(String field1) {
            this.field1 = field1;
        }
    }

    public static class B {
        public final String field2;

        public B(String field2) {
            this.field2 = field2;
        }
    }

    public static class UnsupportedSerializer extends JsonSerializer.None {
        private final Class<?> type;

        public UnsupportedSerializer(Class<?> type) {
            this.type = type;
        }

        @Override
        public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            throw new UnsupportedOperationException("Unsupported type: " + type);
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
            @Override
            public Object findSerializer(Annotated a) {
                if (a instanceof AnnotatedClass
                        && a.getRawType().getPackage().getName().startsWith("stackoverflow")
                        && !a.hasAnnotation(Json.class)) {
                    return new UnsupportedSerializer(a.getRawType());
                }
                return super.findSerializer(a);
            }
        });

        System.out.println(mapper.writeValueAsString(new A("value1")));
        System.out.println(mapper.writeValueAsString(new B("value2")));
    }
}