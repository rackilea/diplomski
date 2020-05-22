public class JacksonIgnoreInherited {

    public static class Base {
        public final String field1;

        public Base(final String field1) {
            this.field1 = field1;
        }
    }

    public static class Bean extends Base {
        public final String field2;

        public Bean(final String field1, final String field2) {
            super(field1);
            this.field2 = field2;
        }
    }

    private static class IgnoreInheritedIntrospector extends JacksonAnnotationIntrospector {
        @Override
        public boolean hasIgnoreMarker(final AnnotatedMember m) {
            return m.getDeclaringClass() == Base.class || super.hasIgnoreMarker(m);
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setAnnotationIntrospector(new IgnoreInheritedIntrospector());
        final Bean bean = new Bean("a", "b");
        System.out.println(mapper
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(bean));
    }

}