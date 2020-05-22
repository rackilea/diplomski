DataInputStream ins = new DataInputStream(socket.getInputStream());
byte[] bytes = new bytes[48];
ins.readFuly(bytes);
ByteBuffer bb = ByteBuffer.wrap(bytes).order(ByteOrder.nativeOrder());

values.tWidth = bb.getFloat();
value.waterLevel = bb.getFloat();
// etc