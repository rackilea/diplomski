Value.Builder[] valueArray = new Value.Builder[values.length];
for (int i = 0; i < values.length; i++) {
  valueArray[i] = DatastoreHelper.makeValue(values[i]);
}
entityBuilder.addProperty(
    DatastoreHelper.makeProperty(name, DatastoreHelper.makeValue(valueArray)));