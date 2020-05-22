byte a = Byte.MAX_VALUE;
byte b = -1;
byte c = -1;
byte d = -1;

System.out.println(((a & 0xff) << 24) | ((b & 0xff) << 16) | ((c & 0xff) << 8) | ((d & 0xff) << 0));