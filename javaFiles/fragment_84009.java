public void checkAndSetChildValues(ObjectNode node, String field, String value, ObjectMapper mapper) {
    int indexDot = field.indexOf('.');
    if (indexDot > -1) {
        String childFieldName = field.substring(0, indexDot);
        ObjectNode child = node.with(childFieldName);
        checkAndSetChildValues(child, field.substring(indexDot + 1), value, mapper);
    } else {
        try{
            node.set(field, mapper.convertValue(value, JsonNode.class));
        } catch(IllegalArgumentException ex){
            logger.debug("could not parse value {} for field {}", value, field);
        }
    }
}


public Object parse(Class type, String entityString) throws UnsupportedEncodingException {

    ObjectMapper mapper = mapperHolder.get();
    ObjectNode node = mapper.createObjectNode();
    Scanner s = new Scanner(entityString).useDelimiter("&|=");
    while (s.hasNext()) {
        String key = s.next();
        String value = s.hasNext() ? URLDecoder.decode(s.next(), "UTF-8") : null;
        checkAndSetChildValues(node, key, value, mapper);
    }
    Object result = mapper.convertValue(node, type);
    return result;
}