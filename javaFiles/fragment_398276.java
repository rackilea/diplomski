// There are dependencies on how you create your floatbuffer for this to work
// I suggest starting with a byte buffer and using asFloatBuffer() when
// you need it as floats.
// ByteBuffer b = ByteBuffer.allocate(somesize);
// FloatBuffer fb = b.asFloatBuffer();
// There will also be endiance issues when you write binary since
// java is big-endian. You can adjust this with Buffer.order(...)
// b.order(ByteOrder.LITTLE_ENDIAN)
// If you're using a hex-editor you'll probably want little endian output
// since most consumer machines (unless you've got a sparc / old mac) are little


FileOutputStream fos = new FileOutputStream("some_binary_output_file_name");
FileChannel channel = fos.getChannel();

channel.write(byteBufferBackingYourFloatBuffer);

fos.close();