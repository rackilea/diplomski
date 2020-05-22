private JsonElement findElementsChildren(JsonElement element, String id) {
    if(element.isJsonObject()) {
        JsonObject jsonObject = element.getAsJsonObject();
        if(id.equals(jsonObject.get("id").getAsString())) {
            return jsonObject.get("children");
        } else {
            return findElementsChildren(element.get("children").getAsJsonArray(), id);
        }
    } else if(element.isJsonArray()) {
        JsonArray jsonArray = element.getAsJsonArray();
        for (JsonElement childElement : jsonArray) {
            JsonElement result = findElementsChildren(childElement, id);
            if(result != null) {
                return result;
            }
        }
    }

    return null;
}