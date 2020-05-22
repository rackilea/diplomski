public class JacksonIncludeProperties {
    @Retention(RetentionPolicy.RUNTIME)
    @interface JsonIncludeProperties {
        String[] value();
    }

    @JsonFilter("filter")
    @JsonIncludeProperties({"a", "b1"})
    static class Bean {
        @JsonProperty
        public final String a = "a";
        @JsonProperty("b1")
        public final String b = "b";
        @JsonProperty
        public final String c =  "c";
    }

    private static class IncludePropertiesFilter extends SimpleBeanPropertyFilter {

        @Override
        protected boolean include(final PropertyWriter writer) {
            final JsonIncludeProperties includeProperties =
                    writer.getContextAnnotation(JsonIncludeProperties.class);
            if (includeProperties != null) {
                return Arrays.asList(includeProperties.value()).contains(writer.getName());
            }
            return super.include(writer);
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter("filter", new IncludePropertiesFilter());
        objectMapper.setFilters(filterProvider);
        System.out.println(objectMapper.writeValueAsString(new Bean()));
    }
}