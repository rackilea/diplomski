final byte[] data = string.getBytes("utf-8");
int length = data.length;
final byte[] bytes = new byte[4];
bytes[3] = (byte) length;
bytes[2] = (byte) length >>> 8;
bytes[1] = (byte) length >>> 16;
bytes[0] = (byte) length >>> 24;