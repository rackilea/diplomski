public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    System.out.println(objectMapper.writeValueAsString(new Entity()));
}

static class Entity {
    ZonedDateTime time = ZonedDateTime.now();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    public ZonedDateTime getTime() {
        return time;
    }
}