Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
classMap.put("dog", Dog.class);
classMap.put("person", Person.class);

InputStream in = null;
JsonParser parser = null;
List<Object> results = new ArrayList<Object>();
try {
  in = this.getClass().getResourceAsStream("input.json");
  parser = factory.createJsonParser(in);
  parser.nextToken();// JsonToken.START_OBJECT
  JsonToken token = null;
  while( (token = parser.nextToken()) == JsonToken.FIELD_NAME ) {
    String name = parser.getText();
    parser.nextToken(); // JsonToken.START_OBJECT
    results.add(parser.readValueAs(classMap.get(name)));
  }
  // ASSERT: token = JsonToken.END_OBJECT
}
finally {
  IOUtils.closeQuietly(in);
  try {
    parser.close();
  }
  catch( Exception e ) {}
}