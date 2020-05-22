public static <T> Optional<String> toJson(final ObjectMapper mapper, final TypeReference<T> type, final T object) {
    try {
        return Optional.ofNullable(mapper.writer().forType(type).writeValueAsString(object));
    } catch (JsonProcessingException e) {
        return Optional.empty();
    }
}

public static void main(String[] args) {
    List<InfoItem> items = new ArrayList<>();
    // Set values in items...

    ObjectMapper mapper = new ObjectMapper();
    Optional<String> json = toJson(mapper, new TypeReference<List<InfoItem>>() {}, items);
    json.ifPresent(x -> System.out.println(x));
}