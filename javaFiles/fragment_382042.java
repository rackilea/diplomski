JsonBuilderFactory factory = Json.createBuilderFactory();
JsonObject value = factory.createArrayBuilder();

while(haveObjects) {
   value.add(Json.createObjectBuilder().add("bookNumber", uriLink1).add("uri", uriAdd1).build());
}
// writer will be constructed with some sort of output, and this will write the JSON value to it.
JsonWriter writer = Json.createWriter();
writer.write(value);