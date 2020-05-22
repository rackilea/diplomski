public static Message fromMap(int uuid, Map<String, Object> fields)  {
  getMessageFactoryFromId(uuid).createMessage(fields);
}

public static Message fromByteBuffer(int uuid, ByteBuffer buffer) {
  getMessageFactoryFromId(uuid).createMessage(buffer);
}