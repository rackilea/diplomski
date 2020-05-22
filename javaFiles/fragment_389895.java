ImmutableMap<String, FooEnum> map = ImmutableMap.of("value", FooEnum.AWESOME, "value2", FooEnum.NARLY);
    final String value;
    try {
        value = objectMapper.writeValueAsString(map);
    } catch (JsonProcessingException e) {
        throw Throwables.propagate(e);
    }

    Map<String, FooEnum> read;
    try {
        read = objectMapper.readValue(value, new TypeReference<Map<String, FooEnum>>() {});
    } catch (IOException e) {
        throw Throwables.propagate(e);
    }