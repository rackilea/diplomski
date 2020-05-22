...
// Get the root JsonObject
JsonObject je = jsontree.getAsJsonObject();
// Get the property tableRows as a JsonArray
JsonArray ja = je.getAsJsonArray("tableRows");
for (Object o : ja) {
    ...
    // Warning JSON is case sensitive so use mailContent instead of mailcontent
    String mail = person.get("mailContent").getAsString();
    ...
}