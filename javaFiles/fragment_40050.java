// This is the byte buffer you get from selecting column "cnt"
ByteBuffer buffer;
int length = buffer.limit() - buffer.position();

byte[] cellValue = new byte[length];

buffer.get(cellValue, 0, length);

return new String(cellValue, Charset.forName("UTF-8"));