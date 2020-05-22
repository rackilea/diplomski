RandomAccessFile in = new RandomAccessFile("filename", "r");
int version = in.readInt();
byte type = in.readByte();
int beginOfData = in.readInt();
byte[] tempId;
in.read(tempId, 0, 16);
String id = new String(tempId);