JsonObject asd = gson.fromJson(reader, JsonObject.class);
if (asd.get("type").getAsString().equals("item")) {
    // Instantiate item
} else {
    // Instantiate property
}