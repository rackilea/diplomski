ByteBuffer buf = ByteBuffer.allocate(8);

// Depending on the device you may need to include the following line
// buf.order(ByteOrder.LITTLE_ENDIAN);

buf.put((byte)16); // (# days in month)
buf.putShort(450); // (distance walked)
buf.putShort(334); // (distance ran)
buf.putShort(800); // (steps taken)
buf.put((byte)4);  // (number of users)

byte[] byteArray = buf.array();