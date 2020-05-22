// Takes input and returns a string with all elements concatenated.
// withExactBigDecimals(true) makes sure trailing zeros (e.g. 5.50) will be
// preserved
static String toRawConcat(String input) throws IOException {
    ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true)
        .configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true)
        .setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));
    JsonNode node = mapper.readTree(input);
    return nodeToString(node);
}

// Removes whitespaces from a string
static String removeWs(String input) {
    return input.replaceAll("\\s+", "");
}

// Inspects the node type and returns the node contents as a string
private static String nodeToString(JsonNode node) {
    switch (node.getNodeType()) {
        case NULL:
        case BOOLEAN:
        case STRING:
            return removeWs(node.asText());
        case NUMBER:
            return node.decimalValue().toString();
        case ARRAY:
            {
                String s = "";
                Iterator<JsonNode> it = node.elements();
                while (it.hasNext()) {
                    s += nodeToString(it.next());
                }
                return s;
            }
        case OBJECT:
            {
                String s = "";
                Iterator<Entry<String, JsonNode>> it = node.fields();
                while (it.hasNext()) {
                    Entry<String, JsonNode> sub = it.next();
                    s += removeWs(sub.getKey()) + nodeToString(sub.getValue());
                }
                return s;
            }
        default:
            throw new UnsupportedOperationException("Node type " + node.getNodeType() + " not supported");
    }