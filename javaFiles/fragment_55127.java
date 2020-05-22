FileChannel channel = new RandomAccessFile("/some/file", "r").getChannel();

long pageSize = ...; // e.g. "3 GB or file size": max(channel.size(), THREE_GB); 
long position = 0;
ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, position, pageSize);

ByteBuffer slice;
int maxLineLength = 30;
byte[] lineBuffer = new byte[maxLineLength];

// Read line at indices 20 - 25
buffer.position(20);
slice = buffer.slice();
slice.get(lineBuffer, 0, 6);
System.out.println("Starting at 20:" + new String(lineBuffer, Charset.forName("UTF8")));

// Read line at indices 0 - 10
buffer.position(0);
slice = buffer.slice();
slice.get(lineBuffer, 0, 11);
System.out.println("Starting at 0:" + new String(lineBuffer, Charset.forName("UTF8")));