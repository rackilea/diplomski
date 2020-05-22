public static <T>  Object convertJSONStringToObject(String json, Class<T> objectClass) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    JavaTimeModule module = new JavaTimeModule();
    mapper.registerModule(module);
    return mapper.readValue(json, objectClass);
}