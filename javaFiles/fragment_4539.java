/**
 * Start a single consumer instance
 * This will use the schema built into the IndexedRecord to decode and create key/value for the message
 */
public void run() {
    ConsumerIterator it = this.stream.iterator();
    while (it.hasNext()) {
        MessageAndMetadata messageAndMetadata = it.next();
        try {
            String key = (String) messageAndMetadata.key();
            IndexedRecord value = (IndexedRecord) messageAndMetadata.message();

            ByteArrayOutputStream bytes = new ByteArrayOutputStream();

            GenericDatumWriter<Object> genericRecordWriter = new GenericDatumWriter<>(value.getSchema());
            genericRecordWriter.write(value, EncoderFactory.get().directBinaryEncoder(bytes, null));

            ReflectDatumReader<T> reflectDatumReader = new ReflectDatumReader<>(value.getSchema());
            T newObject = reflectDatumReader.read(null, DecoderFactory.get().binaryDecoder(bytes.toByteArray(), null));
            IOUtils.closeQuietly(bytes);

            System.out.println("************CONSUMED:  " + key + ": "+ newObject);

        } catch(SerializationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    System.out.println("Shutting down Thread: " + this.threadNumber);
}