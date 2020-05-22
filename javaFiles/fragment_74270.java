public class JacksonUnwrapped {

    private final static String JSON = "{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"result\": { \"field1\":\"value\", \"field2\":123 }\n" +
            "}";


    public static class Result<T> {
        public final String status;
        public final T result;

        @JsonCreator
        public Result(@JsonProperty("status") String status,
                      @JsonProperty("result") T result) {
            this.status = status;
            this.result = result;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "status='" + status + '\'' +
                    ", result=" + result +
                    '}';
        }
    }

    public static class UserProfile {
        public final String field1;
        public final int field2;

        @JsonCreator
        public UserProfile(@JsonProperty("field1") String field1,
                           @JsonProperty("field2") int field2) {
            this.field1 = field1;
            this.field2 = field2;
        }

        @Override
        public String toString() {
            return "UserProfile{" +
                    "field1='" + field1 + '\'' +
                    ", field2=" + field2 +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Result<UserProfile> value = mapper.readValue(JSON, new TypeReference<Result<UserProfile>>() {});
        System.out.println(value.result);
    }

}