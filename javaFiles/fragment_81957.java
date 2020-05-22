public class JacksonView1 {
    public static class publicView{}

    public static class User  {
        public User(Long id, String showName, List<String> callableQueues) {
            this.id = id;
            this.showName = showName;
            this.callableQueues = callableQueues;
        }
        @JsonView(publicView.class)
        public final Long id;

        public final String showName;

        @JsonView(publicView.class)
        public final List<String> callableQueues;
    }

    public static void main(String[] args) {
        User user = new User(123l, "name", Arrays.asList("a", "b"));
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
        mapper.setConfig(mapper.getSerializationConfig()
                .withView(publicView.class));
        System.out.println(mapper.convertValue(user, JsonNode.class));
    }
}