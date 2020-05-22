StringWriter sw = new StringWriter();
Map<String, Object> properties = new HashMap<>();
properties.put(JsonGenerator.PRETTY_PRINTING, true);

JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
JsonWriter jsonWriter = writerFactory.createWriter(sw);

jsonWriter.writeObject(jsonObject); //JsonObject created before
jsonWriter.close();
String prettyPrintedJSON = sw.toString();