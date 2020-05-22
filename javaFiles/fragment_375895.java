Value.Builder listValueBuilder = Value.newBuilder();
for (String value : values) {
  listValueBuilder.addListValue(Value.newBuilder().setStringValue(value));
}
entityBuilder.addProperty(Property.newBuilder()
    .setName(name)
    .setValue(listValueBuilder));