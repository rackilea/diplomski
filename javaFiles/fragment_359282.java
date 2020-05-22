//        DEBUG
ByteBuffer buffer = ByteBuffer.allocate(octets);
buffer.order( ByteOrder.BIG_ENDIAN);
for(byte b: intVal.toByteArray()){
    buffer.put(b);
}