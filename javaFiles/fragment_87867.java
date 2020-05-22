// Create the jsonFactory with an object mapper to serialize object to json
JsonFactory jsonFactory = new JsonFactory(new ObjectMapper());

// Create the byte array output stream
ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

// Create the json generator 
JsonGenerator generator = jsonFactory.createGenerator(outputStream);

// Write the start object, ie. {}
generator.writeStartObject();
// Write the car "car":{}
generator.writeObjectField("car" , car);
// Write the car "boat":{}
generator.writeObjectField("boat" , boat);
// Write the car "airplane":{}
generator.writeObjectField("airplane" , airplane);
// Close the object
generator.writeEndObject();
// And the generator
generator.close();

// Convert the byte array stream to a byte array and publish the message
channel.basicPublish(outputStream.toByteArray());