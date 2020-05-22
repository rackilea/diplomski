// Client code for reading individual messages from a TCP connection

byte type = din.readByte();

// Read the message length, little-endian.
// We cannot use din.readShort because it's big-endian
int lenLo = din.read();
int lenHi = din.read();
short len = (short)(lenLo | (lenHi << 8));
byte [] body = new byte[len];
din.readFully(body);