FileOutputStream fos = new FileOutputStream(file);
ByteArrayOutputStream bos = new ByteArrayOutputStream();
SerializationService serializationService = new DefaultSerializationServiceBuilder().build();
ObjectDataOutput odo = new ObjectDataOutputStream(bos, serializationService);

Book book = new Book();
book.writeData(odo);
bos.writeTo(fos);