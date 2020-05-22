// Get the schema
String strSchema = event.getHeader("flume.avro.schema.literal");
// Get the body
byte[] body = event.getBody();

// Create the avro schema
Schema schema = Schema.Parser.parse(strSchema);

// Get the decoder to use to get the "record" from the event stream in object form
BinaryDecoder decoder = DecoderFactory.binaryDecoder(body, null); 

// Get the datum reader
GenericDatumReader reader = new GenericDatumReader(schema);

// Get the Avro record in object form
GenericRecord record = reader.read(null, decoder);

// Now you can iterate over the fields
for (Schema.Field field : schema.getFields()) {
   Object value = record.get(field.name());

   // Code to add field to JSON to send to ElasticSearch not listed
   // ...

} // for (Schema.Field field : schema.getFields()) {