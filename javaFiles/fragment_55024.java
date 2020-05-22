private String translateObjectToString(Object obj) {
    try {
        return mapper.writeValueAsString(obj);
    } catch (JsonProcessingException ex) {
        throw new ValidationException(ex);
    }
}