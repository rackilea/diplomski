public class JacksonFilters {
    static class Bar {
        final public String prop1;
        final public String prop2;
        final public String prop3;

        Bar(final String prop1, final String prop2, final String prop3) {
            this.prop1 = prop1;
            this.prop2 = prop2;
            this.prop3 = prop3;
        }
    }

    static class Foo {
        @JsonFilter("myFilter1")
        final public Bar p1;
        @JsonFilter("myFilter2")
        final public Bar p2;

        Foo(final Bar p1, final Bar p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        final SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter("myFilter1",
                SimpleBeanPropertyFilter.filterOutAllExcept("prop1"));
        filterProvider.addFilter("myFilter2",
                SimpleBeanPropertyFilter.serializeAllExcept("prop2"));

        final Foo bar = new Foo(new Bar("a", "b", "c"), new Bar("d", "e", "f"));

        final ObjectMapper mapper = new ObjectMapper();
        mapper.setFilters(filterProvider);
        System.out.println(mapper
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(bar));
    }

}