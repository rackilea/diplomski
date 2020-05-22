JsonArray results = jsonParser.parse(json)
        .getAsJsonObject().get("Response")
        .getAsJsonObject().getAsJsonArray("View").get(0)
        .getAsJsonObject().getAsJsonArray("Result");
for (JsonElement result : results) {
    JsonObject address = result.getAsJsonObject().get("Location").getAsJsonObject().getAsJsonObject("Address");
    String postalCode = address.get("PostalCode").getAsString();
    System.out.println(postalCode);
}