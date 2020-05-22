String jsonString = "{\"Products\":[{\"p10\":\"SamsungS5\"},{\"i6\":\"Iphone6\"}]}";
String removeValue = "\"Iphone6\"";

JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
JsonObject jsonObj = jsonReader.readObject();

JsonPatchBuilder builder = Json.createPatchBuilder();

JsonArray jsonArray = jsonObj.getJsonArray("Products"); // [{"p10":"SamsungS5"},{"i6":"Iphone6"}]
for (int i = 0; i < jsonArray.size(); i++) {
    JsonObject entry = jsonArray.get(i).asJsonObject();
    for (JsonValue value : entry.values()) {
        if (value.toString().equals(removeValue)) {
            builder.remove("/Products/" + i);
        }
    }
}

JsonPatch patch = builder.build();
JsonObject newObj = patch.apply(jsonObj);
System.out.println(newObj); // {"Products":[{"p10":"SamsungS5"}]}