// typed from memory, some methods may be off a bit
JsonFactory f = objectMapper.getFactory();
JsonGenerator gen = f.createGenerator(new File("c:\\images.json"));
gen.writeStartArray(); // to get array of objects
// get the DB connection etc
while (r.next()) {
  gen.writeFieldName("image");
  InputStream in = r.getBinaryStream("image");
  gen.writeBinary(in, -1); // length optional for JSON
  in.close();
}