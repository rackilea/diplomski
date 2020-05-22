ByteBuffer myByteBuffer = ByteBuffer.allocate(20);
myByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
FileChannel in = new FileInputStream("sample.bin").getChannel();
in.read(myByteBuffer);
myByteBuffer.flip();
in.close(); // do not forget to close the channel

ShortBuffer myShortBuffer = myByteBuffer.asShortBuffer();
myShortBuffer.get(payload);
System.out.println(Arrays.toString(payload));