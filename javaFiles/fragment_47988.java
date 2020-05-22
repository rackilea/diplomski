PushbackInputStream pbin1=new PushbackInputStream(new FileInputStream("1.dat"));
DataInputStream din=new DataInputStream(pbin1);

double d = din.readDouble(); // Get the double out of the stream
byte[] doubleAsBytes = new byte[8];
ByteBuffer.wrap(doubleAsBytes).putDouble(d); // transform the double into his byte representation
pbin1.unread(doubleAsBytes); // push back the bytes