JsonParser jsonParser = new JsonParser();
JsonObject address = jsonParser.parse(json)
    .getAsJsonObject().get("Response")
    .getAsJsonObject().getAsJsonArray("View").get(0)
    .getAsJsonObject().getAsJsonArray("Result").get(0)
    .getAsJsonObject().get("Location")
    .getAsJsonObject().getAsJsonObject("Address");
String postalCode = address.get("PostalCode").getAsString();