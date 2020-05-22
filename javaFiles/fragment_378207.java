byte b1 = din.readByte();
byte b2 = din.readByte();
byte b3 = din.readByte();
byte b4 = din.readByte();
return ((b4 & 0xff) << 24)
     | ((b3 & 0xff) << 16)
     | ((b2 & 0xff) << 8)
     | ((b1 & 0xff) << 0);