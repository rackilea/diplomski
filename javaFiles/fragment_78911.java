private class TestDeserializer implements JsonDeserializer<Test> {
  public Test deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    JsonObject obj = json.getAsJsonObject();

    int id = obj.get("id").getAsInt();
    String name = obj.get("name").getAsString();

    double distance = obj.get("param_distance").getAsDouble();
    int sampling = obj.get("param_sampling").getAsInt();

    //assuming you have suitable constructors...
    Test test = new Test(id, name, new Parameters(distance, sampling));

    return test;
  }
}