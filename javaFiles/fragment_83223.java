boolean found = false;
for (JsonNode field : IteratorUtils.toList(json.elements())) {
    if (field.has("name") && field.get("name").textValue().equals("test2")) {
        found = true;
        break;
    }
}