JsonBuilderFactory factory = Json.createBuilderFactory();
    JsonObject value = factory.createObjectBuilder()
    .add("c1", factory.createObjectBuilder()
    .add("value11", c1.getValue11()))
    .add("c2", factory.createObjectBuilder()
    .add("value21", c1.getValue21()))