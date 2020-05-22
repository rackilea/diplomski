private boolean containsToken(Request request) {
    try {
        Representation repr = request.getEntity();
        String content = repr.getText();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonContent = objectMapper.readValue(
                                  content, Map.class);

        StringRepresentation sRepr = new StringRepresentation(
                              content, repr.getMediaType());
        request.setEntity(sRepr);

        if (jsonContent.get("token") != null) {
            return true;
        }
    } catch (Exception ex) {
        (...)
    }
    return false;
}