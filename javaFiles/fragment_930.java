private void insertValueIntoDetails(String key, String value, JsonArray details,  int targetIndex, int currentIndex) {
    // if the targetIndex equals the currentIndex ?
    if (targetIndex == currentIndex) {
        // if details doesn't have the value, then insert it
        AtomicBoolean hasValue = new AtomicBoolean(false);
        details.forEach(item -> {
            if (((JsonObject)item).get("ID").getAsString().equals(value.toString())) {
                hasValue.set(true);
            }
        });
        if (!hasValue.get()) {
            JsonObject o = new JsonObject();
            o.addProperty("ID", value);
            o.add("Details", new JsonArray());
            details.add(o);
        }
    }
    // if the targetIndex > currentIndex
    if (targetIndex > currentIndex) {
        // call insertValueIntoDetails with key, value, details of the currentIndex, targetIndex, currentIndex + 1
        JsonArray deets = getDetails(key, details, currentIndex);
        insertValueIntoDetails(key, value, deets, targetIndex, currentIndex + 1);
    }
}