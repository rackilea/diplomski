protected static String generateJsonPathArgumentFromJson(JsonNode jsonNode, String valueSearched) {
    if (jsonNode.isValueNode() && !jsonNode.asText().equals(valueSearched)) {
        return null;
    } else {
        if (jsonNode.isContainerNode()) {
            if (jsonNode.isObject()) {
                Iterator<Map.Entry<String, JsonNode>> elements = jsonNode.fields();
                while (elements.hasNext()) {
                    Map.Entry<String, JsonNode> element = elements.next();
                    String res =  generateJsonPathArgumentFromJson(element.getValue(), valueSearched);
                    if (res != null) {
                        return "." + element.getKey() + res;
                    }
                }
            } else {
                int i = 0;
                Iterator<JsonNode> elements = jsonNode.elements();
                while (elements.hasNext()) {
                    JsonNode element = elements.next();
                    String res = generateJsonPathArgumentFromJson(element, valueSearched);
                    if (res != null) {
                        return "(" + i + ")" + res;
                    }
                    i++;
                }
            }
        }
    }
    return "";
}