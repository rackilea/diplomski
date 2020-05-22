/**
 * Extends deserializer to support ReflectData.
 *
 * @param <V>
 *     value type
 */
public abstract class ReflectKafkaAvroDeserializer<V> extends KafkaAvroDeserializer {

  private Schema readerSchema;
  private DecoderFactory decoderFactory = DecoderFactory.get();

  protected ReflectKafkaAvroDeserializer(Class<V> type) {
    readerSchema = ReflectData.get().getSchema(type);
  }

  @Override
  protected Object deserialize(
      boolean includeSchemaAndVersion,
      String topic,
      Boolean isKey,
      byte[] payload,
      Schema readerSchemaIgnored) throws SerializationException {

    if (payload == null) {
      return null;
    }

    int schemaId = -1;
    try {
      ByteBuffer buffer = ByteBuffer.wrap(payload);
      if (buffer.get() != MAGIC_BYTE) {
        throw new SerializationException("Unknown magic byte!");
      }

      schemaId = buffer.getInt();
      Schema writerSchema = schemaRegistry.getByID(schemaId);

      int start = buffer.position() + buffer.arrayOffset();
      int length = buffer.limit() - 1 - idSize;
      DatumReader<Object> reader = new ReflectDatumReader(writerSchema, readerSchema);
      BinaryDecoder decoder = decoderFactory.binaryDecoder(buffer.array(), start, length, null);
      return reader.read(null, decoder);
    } catch (IOException e) {
      throw new SerializationException("Error deserializing Avro message for id " + schemaId, e);
    } catch (RestClientException e) {
      throw new SerializationException("Error retrieving Avro schema for id " + schemaId, e);
    }
  }
}