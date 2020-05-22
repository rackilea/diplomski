ByteBuffer buffer = ByteBuffer.allocate(4 * 4);
buffer.order(ByteOrder.BIG_ENDIAN);

for (Integer i : intList) {
    buffer.putInt(i);
}

buffer.flip();
return new UUID(buffer.getLong(0), buffer.getLong(8));